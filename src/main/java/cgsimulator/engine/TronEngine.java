package cgsimulator.engine;

import cgsimulator.GameSimulator;
import cgsimulator.Turn;

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
    public boolean isWon(GameSimulator.GamePlayer player) {
        return false;
    }

    @Override
    public String getInitializationInput() {
        return null;
    }
}
