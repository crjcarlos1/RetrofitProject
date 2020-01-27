package patterns.observer.example1;

public class ObserverMain {
    public static void main(String... args) {
        System.out.println("Observer Pattern");
        /*
         *       Objeto acelerador
         *       Objeto motor
         *
         *       El motor observará cada que se pise el acelerador
         * */

        Acelerador acelerador = new Acelerador();
        Motor motor = new Motor();

        acelerador.addMotorObservador(motor);
        acelerador.pisarAcelerador();
        acelerador.pisarAcelerador();

    }
}
