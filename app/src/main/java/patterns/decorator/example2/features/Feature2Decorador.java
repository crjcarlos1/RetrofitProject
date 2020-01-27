package patterns.decorator.example2.features;

import patterns.decorator.example2.decorator.CuentaDecorador;
import patterns.decorator.example2.interfaces.ICuentaBancaria;
import patterns.decorator.example2.models.Cuenta;

public class Feature2Decorador extends CuentaDecorador {

    public Feature2Decorador(ICuentaBancaria cuentaBancaria) {
        super(cuentaBancaria);
    }

    @Override
    public void abrirCuentaBancaria(Cuenta cuenta) {
        super.abrirCuentaBancaria(cuenta);
        cuentaDecorada.abrirCuentaBancaria(cuenta);     //cuentaDecorada es protected; por eso se puede utilizar aqui ya que hereda de Cuenta decorador
        System.out.println("Se agrego caracteristica 2 a la cuenta de: " + cuenta.getCliente());
    }
}
