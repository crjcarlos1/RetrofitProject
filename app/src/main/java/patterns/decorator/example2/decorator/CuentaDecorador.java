package patterns.decorator.example2.decorator;

import patterns.decorator.example2.interfaces.ICuentaBancaria;
import patterns.decorator.example2.models.Cuenta;

public abstract class CuentaDecorador implements ICuentaBancaria {

    protected ICuentaBancaria cuentaDecorada;

    public CuentaDecorador(ICuentaBancaria cuentaBancaria) {
        this.cuentaDecorada = cuentaBancaria;
    }

    @Override
    public void abrirCuentaBancaria(Cuenta cuenta) {
        cuentaDecorada.abrirCuentaBancaria(cuenta);
    }
}
