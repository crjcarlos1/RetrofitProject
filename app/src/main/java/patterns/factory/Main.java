package patterns.factory;

import patterns.factory.factory.ConexionFabrica;
import patterns.factory.factory.IConexion;

public class Main {
    public static void main(String... args) {
        ConexionFabrica fabrica = new ConexionFabrica();

        IConexion conexionOracle = fabrica.getConexion("ORACLE");
        conexionOracle.conectar();
        conexionOracle.desconectar();

        System.out.println("-------------------------");

        IConexion conexionSQLServer = fabrica.getConexion("SQL");
        conexionSQLServer.conectar();
        conexionSQLServer.desconectar();

        System.out.println("-------------------------");

        IConexion conexionPostgre = fabrica.getConexion("POSTGRE");
        conexionPostgre.conectar();
        conexionPostgre.desconectar();
    }
}
