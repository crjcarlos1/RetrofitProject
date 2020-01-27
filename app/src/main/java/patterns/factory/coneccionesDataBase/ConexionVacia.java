package patterns.factory.coneccionesDataBase;

import patterns.factory.factory.IConexion;

public class ConexionVacia implements IConexion {
    @Override
    public void conectar() {
        System.out.println("No es especificó proveedor");
    }

    @Override
    public void desconectar() {
        System.out.println("No se especificó proveedor");
    }
}
