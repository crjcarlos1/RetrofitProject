package patterns.decorator.example1;

import patterns.decorator.example1.features.AutoElectricoFeature;

//https://www.youtube.com/watch?v=Hm4KE9QdoJ0&list=PL1DEB0E818EB4AFC6&index=45
public class Main {

    public static void main(String... args) {
        Automovil carroEstandar = new CarroEstandar("Chevy");

        //utilizando decorador
        carroEstandar = new AutoElectricoFeature(carroEstandar);

        carroEstandar.empezar();
        carroEstandar.acelerar();
        carroEstandar.detenerse();
    }

}
