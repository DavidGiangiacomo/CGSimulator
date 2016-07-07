package cgsimulator.engine;

import org.junit.Before;
import org.junit.Test;

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

//    @Test
//    public void shouldHaveWin() {
//        givenThorAndLightPositionsAre(0, 0, 0, 0);
//
//        thenGameIsWon();
//    }
//
//    private void thenGameIsWon() {
//        assertThat(thorEngine.isWon()).isTrue();
//    }
}