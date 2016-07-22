package cgsimulator;

import cgsimulator.exception.InvalidInputException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

    public interface GameEngine {
        String nextTurnInput();
        boolean hasNextTurn();
        void setPlayerOutput(String input) throws InvalidInputException;
        boolean isWon();
        String getInitializationInput();
    }

    public interface GamePlayer {
        void initialize(String initInput) throws IOException;
        void setInput(String input) throws IOException;
        String getOutput() throws IOException;
    }

    private GameEngine engine;
    private GamePlayer player;
    private List<String> output;

    public GameSimulator() {
        output = new ArrayList<>();
    }

    public void setPlayer(GamePlayer player) {
        this.player = player;
    }

    public void setGameEngine(GameEngine gameEngine) {
        engine = gameEngine;
    }

    public void run() throws IOException{
        player.initialize(engine.getInitializationInput());
        while(engine.hasNextTurn()) {
            player.setInput(engine.nextTurnInput());
            output.add(player.getOutput());
        }
    }

    public boolean isWinning() {
        return engine.isWon();
    }

    public List<String> outputs() {
        return output;
    }

}
