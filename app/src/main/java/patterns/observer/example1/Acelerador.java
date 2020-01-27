package patterns.observer.example1;

import java.util.ArrayList;
import java.util.List;

public class Acelerador implements SujetoObservable {

    /*al acelerador le tenemos que pasar al menos un motor*/
    private List<Observador> observadores;

    /*Constructor del acelerador*/

    public Acelerador() {
        observadores = new ArrayList<>();
    }

    public void addMotorObservador(Observador observadorMotor) {
        observadores.add(observadorMotor);
    }

    public void pisarAcelerador() {
        notificar();
    }

    @Override
    public void notificar() {
        for (Observador observador : observadores) {
            observador.update();
        }
    }

}
