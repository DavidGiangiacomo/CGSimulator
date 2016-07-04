public class TronEngine {

    public static final int WIDTH = 30;
    public static final int HEIGHT = 20;
    public int nbPlayer;

    public TronEngine() {
        nbPlayer = 2;
    }

    public Turn initNextTurn() {
        return new Turn();
    }
}
