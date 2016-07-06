public class TronEngine implements GameSimulator.GameEngine {

    public static final int WIDTH = 30;
    public static final int HEIGHT = 20;
    public int nbPlayer;

    public TronEngine() {
        nbPlayer = 2;
    }

    public Turn initNextTurn() {
        return new Turn();
    }

    @Override
    public String nextTurnInput() {
        return null;
    }

    @Override
    public boolean hasNextTurn() {
        return false;
    }

    @Override
    public boolean isWinning(GameSimulator.GamePlayer player) {
        return false;
    }
}
