package cgsimulator;

import cgsimulator.engine.ThorEp1Engine;

import java.io.IOException;

public class Launcher {

    protected static GameSimulator gs = new GameSimulator();

    public static void main(String... args) throws IOException {
        initGameSimulator(new ThorEp1Engine(), args[0]);
        gs.run();
        System.out.println(gs.isWinning());
    }

    protected static void initGameSimulator(GameSimulator.GameEngine engine, String playerJarPath) throws IOException{
        gs.setGameEngine(engine);
        gs.setPlayer(new JavaPlayer(playerJarPath));
    }

}
