package patterns.singleton;

public class SingletonMain {

    public static void main(String args[]) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.setMessage("Mensaje desde logger 1");
        logger2.log(logger2.getMessage());
    }

}
