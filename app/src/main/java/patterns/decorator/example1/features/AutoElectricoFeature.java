package patterns.decorator.example1.features;

import patterns.decorator.example1.Automovil;
import patterns.decorator.example1.AutomovilDecorator;

public class AutoElectricoFeature extends AutomovilDecorator {

    public AutoElectricoFeature(Automovil automovil) {
        super(automovil);
    }

    @Override
    public void acelerar() {
        System.out.println("acelerando de forma electrica");
        getAutomovil().acelerar();
    }

    @Override
    public void detenerse() {
        System.out.println("deteniendo de forma electrica");
        getAutomovil().detenerse();
    }

    @Override
    public void empezar() {
        System.out.println("empezando de forma electrica");
        getAutomovil().empezar();
    }
}
