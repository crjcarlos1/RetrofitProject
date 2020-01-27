package patterns.decorator.example2.models;

import patterns.decorator.example2.interfaces.ICuentaBancaria;

public class CuentaAhorro implements ICuentaBancaria {

    @Override
    public void abrirCuentaBancaria(Cuenta cuenta) {
        System.out.println("----------------------");
        System.out.println("Se abrio una cuenta de ahorro");
        System.out.println("Cliente: " + cuenta.getCliente());
    }

}
