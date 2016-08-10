package cgsimulator;

import cgsimulator.engine.ThorEp1Engine;

public class Launcher {

    protected static GameSimulator gs = new GameSimulator();

    public static void main(String[] args) {
        initGameSimulator(new ThorEp1Engine(), "/opt/trucmuche.jar");

    }

    protected static void initGameSimulator(GameSimulator.GameEngine engine, String playerJarPath){
//        gs.setGameEngine(engine);
    }

}
