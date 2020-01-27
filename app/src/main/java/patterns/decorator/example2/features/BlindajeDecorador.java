package patterns.decorator.example2.features;

import patterns.decorator.example2.decorator.CuentaDecorador;
import patterns.decorator.example2.interfaces.ICuentaBancaria;
import patterns.decorator.example2.models.Cuenta;

public class BlindajeDecorador extends CuentaDecorador {

    public BlindajeDecorador(ICuentaBancaria cuentaBancaria) {
        super(cuentaBancaria);
    }

    @Override
    public void abrirCuentaBancaria(Cuenta cuenta) {
        super.abrirCuentaBancaria(cuenta);
        cuentaDecorada.abrirCuentaBancaria(cuenta);         //cuentaDecorada es protected; por eso se puede utilizar aqui ya que hereda de Cuenta decorador
        agregarBlindaje(cuenta);
    }

    public void agregarBlindaje(Cuenta cuenta) {
        System.out.println("Se agrego blindaje a la cuenta del cliente: " + cuenta.getCliente());
    }

}
