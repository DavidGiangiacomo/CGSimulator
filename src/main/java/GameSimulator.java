public class GameSimulator {


    public interface GameEngine {
        String nextTurnInput();
    }

    public interface GamePlayer {
        void setInput(String s);
        String getOutput();
    }

    private GameEngine gameEngine;
    private GamePlayer player;

    public void setPlayer(GamePlayer player) {
        this.player = player;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void run() {
        player.setInput(gameEngine.nextTurnInput());
    }

    public String getOutput() {
        return player.getOutput();
    }
}
