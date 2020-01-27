package patterns.observer.example1;

public class Motor implements Observador {

    /*Constructor*/

    public Motor() {
    }

    /*acción que se realizar despues de que se pisa el acelerador*/
    @Override
    public void update() {
        System.out.println("Subir potencia y velocidad");
    }

}
