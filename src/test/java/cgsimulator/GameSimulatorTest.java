package cgsimulator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameSimulatorTest {

    @Mock
    private GameSimulator.GameEngine engine;

    @Mock
    private GameSimulator.GamePlayer player;

    private GameSimulator gameSimulator;

    @Before
    public void setup() {
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
        when(engine.isWon(player)).thenReturn(true);
        when(engine.hasNextTurn()).thenReturn(true, false);
        when(player.getOutput()).thenReturn("valid");
    }

    private void whenSimulatorRuns() {
        gameSimulator.run();
    }

    private void thenPlayerWins() {
        List<String> outputs = gameSimulator.outputs();
        assertThat(outputs.get(outputs.size() - 1)).isEqualTo("valid");
        assertThat(gameSimulator.isWinning()).isTrue();
    }

    @Test
    public void should_not_valid_a_one_player_game() {
        givenPlayerOutputIsInvalid();

        whenSimulatorRuns();

        thenPlayerLoses();
    }

    private void givenPlayerOutputIsInvalid() {
        when(engine.isWon(player)).thenReturn(false);
        when(engine.hasNextTurn()).thenReturn(true, false);
        when(player.getOutput()).thenReturn("false");
    }

    private void thenPlayerLoses() {
        List<String> outputs = gameSimulator.outputs();
        assertThat(outputs.get(outputs.size() - 1)).isEqualTo("false");
        assertThat(gameSimulator.isWinning()).isFalse();
    }

    @Test
    public void player_should_win_after_two_turns() {
        givenAPlayerWhoNeedsTwoTurns();

        whenSimulatorRuns();

        thenPlayerWinsAfterTwoTurns();
    }

    private void givenAPlayerWhoNeedsTwoTurns() {
        when(engine.isWon(player)).thenReturn(true);
        when(engine.hasNextTurn()).thenReturn(true, true, false);
        when(player.getOutput()).thenReturn("turn", "valid");
    }

    private void thenPlayerWinsAfterTwoTurns() {
        List<String> outputs = gameSimulator.outputs();
        assertThat(outputs.get(0)).isEqualTo("turn");
        assertThat(outputs.get(1)).isEqualTo("valid");
        assertThat(gameSimulator.isWinning()).isTrue();
    }

    @Test
    public void player_should_win_a_game_with_initialization() {
        givenPlayerOutputIsValid();
        AndEngineProvideInitialization();

        whenSimulatorRuns();

        thenPlayerWins();
        AndInitializationWasCalled();
    }

    private void AndEngineProvideInitialization() {
        when(engine.getInitializationInput()).thenReturn("init");
    }

    private void AndInitializationWasCalled() {
        verify(player).initialize(anyString());
    }


}
