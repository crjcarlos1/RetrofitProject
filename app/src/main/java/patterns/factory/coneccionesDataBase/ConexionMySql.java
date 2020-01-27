package patterns.factory.coneccionesDataBase;

import patterns.factory.factory.IConexion;

public class ConexionMySql implements IConexion {

    private String host;
    private String puerto;
    private String usuauario;
    private String contrasenia;

    public ConexionMySql(String puerto, String usuauario, String contrasenia) {
        this.puerto = puerto;
        this.usuauario = usuauario;
        this.contrasenia = contrasenia;
    }

    @Override
    public void conectar() {
        System.out.println("Se conecto a MySQL");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecto de MySQL");
    }

}
