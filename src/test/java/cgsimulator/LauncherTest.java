package cgsimulator;

import cgsimulator.engine.ThorEp1Engine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LauncherTest {

    @Mock
    GameSimulator mockSimulator;

    @Test
    public void should_init_game() throws IOException {

        Launcher.gs = mockSimulator;

        ThorEp1Engine engine = new ThorEp1Engine();
        Launcher.initGameSimulator(engine, Thread.currentThread().getContextClassLoader().getResource("testable.jar").getPath());

        verify(Launcher.gs).setGameEngine(engine);
        verify(Launcher.gs).setPlayer(any(GameSimulator.GamePlayer.class));
    }


}