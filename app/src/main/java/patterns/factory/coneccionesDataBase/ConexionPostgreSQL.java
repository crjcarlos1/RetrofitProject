package patterns.factory.coneccionesDataBase;

import patterns.factory.factory.IConexion;

public class ConexionPostgreSQL implements IConexion {

    private String host;
    private String puerto;
    private String usuauario;
    private String contrasenia;

    public ConexionPostgreSQL(String host, String puerto, String usuauario, String contrasenia) {
        this.host = host;
        this.puerto = puerto;
        this.usuauario = usuauario;
        this.contrasenia = contrasenia;
    }

    @Override
    public void conectar() {
        System.out.println("Se conecto a Postgre");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecto de Postgre");
    }
}
