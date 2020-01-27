package patterns.decorator.example2;

import patterns.decorator.example2.features.BlindajeDecorador;
import patterns.decorator.example2.interfaces.ICuentaBancaria;
import patterns.decorator.example2.models.Cuenta;
import patterns.decorator.example2.models.CuentaCorriente;

//      https://www.youtube.com/watch?v=mOhrurNEgGQ
public class Main {
    public static void main(String... args) {

        Cuenta cuenta = new Cuenta(1, "cRalos");
        ICuentaBancaria cuentaBancaria = new CuentaCorriente();

        //aplicamos decorador a la cuenta
        cuentaBancaria = new BlindajeDecorador(cuentaBancaria);
        //cuentaBancaria = new Feature2Decorador(cuentaBancaria);

        //abricumos cuenta bancaria
        cuentaBancaria.abrirCuentaBancaria(cuenta);

    }
}
