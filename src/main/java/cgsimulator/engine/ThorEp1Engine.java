package cgsimulator.engine;

import cgsimulator.GameSimulator;

public class ThorEp1Engine implements GameSimulator.GameEngine {


    private static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Position)) {
                return false;
            }
            Position other = (Position) obj;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    private Position thorPosition;
    private Position lightPosition;
    private int remainingTurns;

    public void initialize(int thorX, int thorY, int lightX, int lightY, int remainingTurns) {
        this.thorPosition = new Position(thorX, thorY);
        this.lightPosition = new Position(lightX, lightY);
        this.remainingTurns = remainingTurns;
    }

    @Override
    public String nextTurnInput() {
        return null;
    }

    @Override
    public boolean hasNextTurn() {
        return remainingTurns > 0 && !thorPosition.equals(lightPosition);
    }

    @Override
    public boolean isWon(GameSimulator.GamePlayer player) {
        return false;
    }

    @Override
    public String getInitializationInput() {
        return lightPosition + " " + thorPosition;
    }
}
