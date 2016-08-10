package cgsimulator;

import cgsimulator.engine.ThorEp1Engine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LauncherTest {

    @Mock
    GameSimulator mockSimulator;

    @Test
    public void should_init_game(){

        Launcher.gs = mockSimulator;

        ThorEp1Engine engine = new ThorEp1Engine();
        Launcher.initGameSimulator(engine, "/opt/trucmuche.jar");

        verify(Launcher.gs).setGameEngine(engine);
        verify(Launcher.gs).setPlayer(any(GameSimulator.GamePlayer.class));
    }


}