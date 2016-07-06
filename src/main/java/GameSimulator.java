public class GameSimulator {

    public interface GameEngine {
        String nextTurnInput();
        boolean hasNextTurn();
        boolean isWinning(GamePlayer player);
    }

    public interface GamePlayer {
        void setInput(String input);
        String getOutput();
    }

    private GameEngine engine;
    private GamePlayer player;
    private StringBuilder output = new StringBuilder();

    public void setPlayer(GamePlayer player) {
        this.player = player;
    }

    public void setGameEngine(GameEngine gameEngine) {
        engine = gameEngine;
    }

    public void run() {
        while(engine.hasNextTurn()) {
            player.setInput(engine.nextTurnInput());
            output.append(player.getOutput()).append("\n");
        }
    }

    public boolean isWinning() {
        return engine.isWinning(player);
    }

    public String output() {
        return output.toString();
    }

}
