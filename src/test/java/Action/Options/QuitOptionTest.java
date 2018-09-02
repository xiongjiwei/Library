package Action.Options;

import Controller.SystemEnvironment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class QuitOptionTest {

    @Test
    void should_stop_run_when_quit() {
        SystemEnvironment.startSystem();

        new QuitOption(null).doAction(null);

        assertFalse(SystemEnvironment.isRun);
    }

}