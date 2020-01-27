package patterns.factory.factory;

import patterns.factory.coneccionesDataBase.ConexionMySql;
import patterns.factory.coneccionesDataBase.ConexionOracle;
import patterns.factory.coneccionesDataBase.ConexionPostgreSQL;
import patterns.factory.coneccionesDataBase.ConexionSQLServer;
import patterns.factory.coneccionesDataBase.ConexionVacia;

public class ConexionFabrica {

    public IConexion getConexion(String motor) {

        if (motor == null || motor.length() == 0) {
            return new ConexionVacia();
        }
        if (motor.equals("MYSQL")) {
            return new ConexionMySql("111", "user", "root");
        }
        if (motor.equals("ORACLE")) {
            return new ConexionOracle("111", "1111", "user", "root");
        }
        if (motor.equals("POSTGRE")) {
            return new ConexionPostgreSQL("1111", "111", "user", "root");
        }
        if (motor.equals("SQL")) {
            return new ConexionSQLServer("111", "111", "user", "lkjhflkd");
        }

        return new ConexionVacia();

    }

}
