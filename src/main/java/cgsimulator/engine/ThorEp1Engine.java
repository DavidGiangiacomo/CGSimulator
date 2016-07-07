package cgsimulator.engine;

import cgsimulator.GameSimulator;
import cgsimulator.exception.InvalidInputException;

import java.util.HashSet;
import java.util.Set;

public class ThorEp1Engine implements GameSimulator.GameEngine {


    private enum validCommands {
        N, S, E, W, NE, NW, SE, SW
    }

    private static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
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
        return String.valueOf(remainingTurns);
    }

    @Override
    public boolean hasNextTurn() {
        return remainingTurns > 0 && !thorPosition.equals(lightPosition);
    }

    @Override
    public void setPlayerOutput(String input) throws InvalidInputException {
        validateInput(input);

        updateGameDatas(input);
    }

    private void updateGameDatas(String input) {
        if ('N' == input.charAt(0)) {
            thorPosition.y--;
        } else if ('S' == input.charAt(0)) {
            thorPosition.y++;
        }
        if (input.contains("E")) {
            thorPosition.x++;
        } else if (input.contains("W")) {
            thorPosition.x--;
        }
        remainingTurns--;
    }

    private void validateInput(String input) throws InvalidInputException {
        try {
            validCommands.valueOf(input);
        }catch (IllegalArgumentException e) {
            throw new InvalidInputException(input, e);
        }
    }

    @Override
    public boolean isWon() {
        return thorPosition.equals(lightPosition);
    }

    @Override
    public String getInitializationInput() {
        return lightPosition + " " + thorPosition;
    }
}
