package patterns.decorator.example1;

public abstract class AutomovilDecorator implements Automovil {

    private Automovil automovil;

    public AutomovilDecorator(Automovil automovil) {
        this.automovil = automovil;
    }

    protected Automovil getAutomovil() {
        return automovil;
    }

}
