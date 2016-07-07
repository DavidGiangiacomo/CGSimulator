package cgsimulator;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

    public interface GameEngine {
        String nextTurnInput();
        boolean hasNextTurn();
        boolean isWinning(GamePlayer player);
        String getInitializationInput();
    }

    public interface GamePlayer {
        void setInput(String input);
        void initialize(String initInput);
        String getOutput();
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

    public void run() {
        player.initialize(engine.getInitializationInput());
        while(engine.hasNextTurn()) {
            player.setInput(engine.nextTurnInput());
            output.add(player.getOutput());
        }
    }

    public boolean isWinning() {
        return engine.isWinning(player);
    }

    public List<String> outputs() {
        return output;
    }

}
