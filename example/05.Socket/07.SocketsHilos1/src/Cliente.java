import java.io.*;
import java.net.*;

public class Cliente {
	private String host;
	int puerto;

	Socket socket = null;
	BufferedReader entrada = null;
	PrintWriter salida = null;

	public Cliente(String host, int puerto) {
		this.host = host;
		this.puerto = puerto;
	}

	public static void main(String[] args) {
		String ip="localhost";
                String puerto="7777";
		System.out.println("Conectandose a '" + ip + "' en el puerto " + puerto);
		Cliente cliente = new Cliente(ip, Integer.parseInt(puerto));
		cliente.iniciar();

	}

	public boolean iniciar() {
		if (!conectar())
			return false;
		if (!obtenerFlujoSalida())
			return false;
		if (!obtenerFlujoEntrada())
			return false;
		if (!protocolo())
			return false;
		terminar();
		return true;
	}

	private boolean conectar() {
		try {
			socket = new Socket(host, puerto);

		} catch (UnknownHostException exc) {
			System.out.println(
				"No se pudo establecer una conexion con el host '"
					+ host
					+ "'.");
			return false;

		} catch (IOException e) {
			System.out.println("Error de E/S al crear el socket.");
			return false;
		}
		System.out.println(
			"Conectado al host " + socket.getInetAddress().getHostName());
		return true;
	}

	private boolean obtenerFlujoSalida() {
		try {
			salida = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException exc) {
			System.out.println("Error de E/S al crear el flujo de salida");
			terminar();
			return false;
		}
		System.out.println("Flujo de salida abierto");
		return true;
	}

	private boolean obtenerFlujoEntrada() {
		try {
			entrada =
				new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.out.println("Error de E/S al crear el flujo de entrada.");
			terminar();
			return false;

		}
		System.out.println("Flujo de entrada abierto");
		return true;

	}

	private boolean protocolo() {
		String entradaUsuario, entradaServidor;
		try {
			BufferedReader consola =
				new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Mensaje: ");
			entradaUsuario = consola.readLine();
			while (!entradaUsuario.equals("chao")) {
				salida.println(entradaUsuario);
				entradaServidor = leer();
				System.out.println(entradaServidor);
				System.out.print("Mensaje: ");
				entradaUsuario = consola.readLine();

			}

		} catch (IOException exc) {
			System.err.println("Error al tratar de leer datos del servidor");
			return false;
		}
		salida.println(entradaUsuario);
		terminar();
		return true;

	}

	private String leer() {
		String temp = null;
		try {
			while ((temp = entrada.readLine()) == null);
		} catch (IOException e) {
			System.out.println("Ocurri� un error al leer datos.");
		}
		return temp;
	}

	public boolean terminar() {
		try {
			entrada.close();
			salida.close();
			if (!socket.isClosed())
				socket.close();
		} catch (IOException exc) {
			System.out.println("Ocurri� un error al cerrar la conexion");
			return false;
		}
		System.out.println("Conexion terminada");
		return true;
	}

} // Fin de la clase
