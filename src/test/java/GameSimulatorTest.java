import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameSimulatorTest {

    @Mock
    private GameSimulator.GameEngine engine;

    @Mock
    private GameSimulator.GamePlayer player;

    private GameSimulator gameSimulator;

    @Before
    public void init() {
        gameSimulator = new GameSimulator();
        gameSimulator.setGameEngine(engine);
        gameSimulator.setPlayer(player);
    }
    @Test
    public void should_valid_a_one_player_game() {
        givenPlayerOutputIsValid();

        whenSimulatorRuns();

        thenPlayerWins();
    }

    private void givenPlayerOutputIsValid() {
        when(engine.isWinning(player)).thenReturn(true);
        when(engine.hasNextTurn()).thenReturn(true, false);
        when(player.getOutput()).thenReturn("valid");
    }

    private void whenSimulatorRuns() {
        gameSimulator.run();
    }

    private void thenPlayerWins() {
        assertThat(gameSimulator.output()).isEqualTo("valid\n");
        assertThat(gameSimulator.isWinning()).isTrue();
    }

    @Test
    public void should_not_valid_a_one_player_game() {
        when(engine.isWinning(player)).thenReturn(false);
        givenPlayerOutputIsInvalid();

        whenSimulatorRuns();

        thenPlayerLoses();
    }

    private void givenPlayerOutputIsInvalid() {
        when(engine.isWinning(player)).thenReturn(false);
        when(engine.hasNextTurn()).thenReturn(true, false);
        when(player.getOutput()).thenReturn("false");
    }

    private void thenPlayerLoses() {
        assertThat(gameSimulator.output()).isEqualTo("false\n");
        assertThat(gameSimulator.isWinning()).isFalse();
    }

    @Test
    public void player_should_win_after_two_turns() {
        when(engine.isWinning(player)).thenReturn(true);
        when(engine.hasNextTurn()).thenReturn(true, true, false);
        when(player.getOutput()).thenReturn("turn", "valid");

        whenSimulatorRuns();

        thenPlayerWinsAfterTwoTurns();
    }

    private void thenPlayerWinsAfterTwoTurns() {
        assertThat(gameSimulator.output()).isEqualTo("turn\nvalid\n");
        assertThat(gameSimulator.isWinning()).isTrue();
    }
}
