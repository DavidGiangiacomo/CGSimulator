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
    }
    @Test
    public void should_valid_a_one_player_game() {
        when(player.getOutput()).thenReturn("valid");
        gameSimulator.setGameEngine(engine);
        gameSimulator.setPlayer(player);

        gameSimulator.run();

        assertThat(gameSimulator.getOutput()).isEqualTo("valid");
    }

    @Test
    public void should_not_valid_a_one_player_game() {
        when(player.getOutput()).thenReturn("invalid");
        gameSimulator.setGameEngine(engine);
        gameSimulator.setPlayer(player);

        gameSimulator.run();

        assertThat(gameSimulator.getOutput()).isEqualTo("invalid");
    }
}
