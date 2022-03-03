package InterfazServidor;

import servidor.ServidorTCP;

public class InterfazServidor {

    private static ServidorTCP srv;
    public InterfazServidor(ServidorTCP servidor) {
        System.out.println("IServidor >> El servidor esta recibiendo Conexiones......");
        //Escucha las solicitudes de conexion de los clientes
        srv.recibirConexiones();
    }

    public static void main(String[] args) {
        try {
            //el properties donde se encuentran las caracteristicas del servidor
            String archivoPropiedades = "D:\\UDistrital\\Gestion Academica\\Pregrado\\Prog Avanzada\\Clase 2021\\Clase 18 D - Sockets y Archivos\\PruebaSocketsV\\src\\data\\servidor.properties";
            srv = new ServidorTCP(archivoPropiedades);
            //activa la intefaz serivodr
            new InterfazServidor(srv);
        } catch (Exception e) {
            System.out.println("IServidor >> Error al crear el Servidor");
        }
    }
}