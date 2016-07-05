import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TronEngineTest {

    @Test
    public void grid_size_is_30_by_20() {
        assertThat(TronEngine.WIDTH).isEqualTo(30);
        assertThat(TronEngine.HEIGHT).isEqualTo(20);
    }

    @Test
    public void display_players_output_for_two_players() {
        TronEngine tronEngine = new TronEngine();
        Turn turn = tronEngine.initNextTurn();

        assertThat(tronEngine.nbPlayer).isEqualTo(2);
        assertThat(turn.outputForPlayer(0)).isEqualTo("2 0\n0 0 0 0");
        assertThat(turn.outputForPlayer(1)).isEqualTo("2 1\n0 0 0 0");
    }

    @Test
    public void should_launch_tron_players() {
        
    }

}