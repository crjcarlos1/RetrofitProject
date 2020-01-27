package patterns.decorator.example1;

public class CarroEstandar implements Automovil {

    private String nombre;

    public CarroEstandar(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void acelerar() {
        System.out.println("Automovil estandar acelerando");
    }

    @Override
    public void detenerse() {
        System.out.println("Automoovil estandar deteniendose");
    }

    @Override
    public void empezar() {
        System.out.println("Automovil estandar empezando");
    }
}
