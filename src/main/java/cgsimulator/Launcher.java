package cgsimulator;

import java.io.IOException;

import cgsimulator.engine.ThorEp1Engine;

public class Launcher {

    protected static GameSimulator gs = new GameSimulator();

    public static void main(final String... args) throws IOException {
        initGameSimulator(new ThorEp1Engine(), args[0]);
        gs.run();
        System.out.println(gs.isWinning());
    }

    protected static void initGameSimulator(final ThorEp1Engine engine, final String playerJarPath) throws IOException {
        // TODO: engine need to be standardized for the launch sequence
        // engine.initialize(5, 4, 31, 4, 100);
        gs.setGameEngine(engine);
        gs.setPlayer(new JavaPlayer(playerJarPath));
    }

}
