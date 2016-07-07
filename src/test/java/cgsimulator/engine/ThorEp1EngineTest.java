package cgsimulator.engine;

import cgsimulator.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import java.util.IllegalFormatException;

import static org.assertj.core.api.Assertions.assertThat;

public class ThorEp1EngineTest {

    private ThorEp1Engine thorEngine;

    @Before
    public void setup() {
        thorEngine = new ThorEp1Engine();
    }

    @Test
    public void should_get_light_and_thor_positions() {
        givenThorAndLightPositionsAre(0, 0, 36, 17);

        thenInitializationInputIs("36 17 0 0");
    }

    private void thenInitializationInputIs(String expected) {
        assertThat(thorEngine.getInitializationInput()).isEqualTo(expected);
    }

    private void givenThorAndLightPositionsAre(int tx, int ty, int lx, int ly) {
        thorEngine.initialize(tx, ty, lx, ly, 1);
    }

    @Test
    public void should_have_next_turn() {
        givenThorIsNotOnLightAndHasRemainingTurns();

        thenThereIsNextTurn();
    }

    private void givenThorIsNotOnLightAndHasRemainingTurns() {
        thorEngine.initialize(0, 0, 1, 1, 5);
    }

    private void thenThereIsNextTurn() {
        assertThat(thorEngine.hasNextTurn()).isTrue();
    }

    @Test
    public void shouldHaveWin() {
        givenThorAndLightPositionsAre(0, 0, 0, 0);

        thenGameIsWon();
    }

    private void thenGameIsWon() {
        assertThat(thorEngine.isWon()).isTrue();
    }

    @Test
    public void should_move_thor_SE_and_win() throws InvalidInputException {
        givenThorAndLightPositionsAre(0, 0, 1, 1);

        whenPlayerInputsAre("SE");

        thenGameIsWon();
        andNextTurnOutputIs("0");
    }

    private void whenPlayerInputsAre(String direction) throws InvalidInputException {
        thorEngine.setPlayerOutput(direction);
    }

    private void andNextTurnOutputIs(String expectedRemainingTurns) {
        assertThat(thorEngine.nextTurnInput()).isEqualTo(expectedRemainingTurns);
    }

    @Test
    public void should_move_thor_W_and_win() throws InvalidInputException {
        givenThorAndLightPositionsAre(1, 0, 0, 0);

        whenPlayerInputsAre("W");

        thenGameIsWon();
        andNextTurnOutputIs("0");
    }

    @Test
    public void should_move_thor_N_and_win() throws InvalidInputException {
        givenThorAndLightPositionsAre(0, 1, 0, 0);

        whenPlayerInputsAre("N");

        thenGameIsWon();
        andNextTurnOutputIs("0");
    }
    @Test
    public void should_move_thor_NW_and_win() throws InvalidInputException {
        givenThorAndLightPositionsAre(1, 1, 0, 0);

        whenPlayerInputsAre("NW");

        thenGameIsWon();
        andNextTurnOutputIs("0");
    }

    @Test(expected = InvalidInputException.class)
    public void should_raise_error_with_invalid_move() throws InvalidInputException {
        givenThorAndLightPositionsAre(1, 1, 0, 0);

        whenPlayerInputsAre("WN");
    }
}