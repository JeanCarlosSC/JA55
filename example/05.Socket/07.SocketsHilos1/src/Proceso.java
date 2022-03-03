import java.io.*;
import java.net.*;

public class Proceso implements Runnable {
	private Socket socket = null;
	PrintWriter salida = null;
	BufferedReader entrada = null;
	String[] preguntas = { "hola", "bien, y tu?", "todo bien?" };
	String[] respuestas = { "hola, como estas?", "bien", "si" };
	String otraRespuesta = "que?";
	String terminar = "chao";

	public Proceso(Socket socket) {
		this.socket = socket;

	}
	public void run() {
		obtenerFlujoSalida();
		obtenerFlujoEntrada();
		protocolo();
		terminar();
	}

	private boolean protocolo() {
		int i;
		String temp;
		temp = leer();
		while (!temp.equals(terminar)) {
			for (i = 0; i < preguntas.length; i++) {
				if (temp.equals(preguntas[i])) {
					salida.println(respuestas[i]);
					break;
				}
			}
			if (i == preguntas.length)
				salida.println(otraRespuesta);
			temp = leer();
		}

		return true;
	}

	private String leer() {
		String temp = null;
		try {
			while ((temp = entrada.readLine()) == null);
		} catch (IOException exc) {
			System.out.println("Ocurrio un error al leer los datos...");
			terminar();
		}
		return temp;
	}

	private boolean terminar() {
		try {
			entrada.close();
			salida.close();
			if (!socket.isClosed())
				socket.close();
		} catch (IOException exc) {
			System.out.println("Error al cerrar el socket en el servidor...");
			return false;
		}
		System.out.println("La conexion ha sido cerrada...");
		return true;
	}

	private void escribir(String cadena) {
		salida.println(cadena);
	}

	private boolean obtenerFlujoEntrada() {
		try {
			entrada =
				new BufferedReader(
					new InputStreamReader(socket.getInputStream()));

		} catch (IOException exc) {
			System.out.println("Error de E/S al crear el flujo de entrada");
			return false;
		}

		return true;
	}

	private boolean obtenerFlujoSalida() {
		try {
			salida = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException exc) {
			System.out.println("Error de E/S ak crear el flujo de salida");
			return false;
		}
		System.out.println("Flujo de salida abierto...");
		return true;
	}

}
