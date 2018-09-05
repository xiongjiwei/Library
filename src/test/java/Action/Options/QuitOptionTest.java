package Action.Options;

import Controller.SystemEnvironment;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class QuitOptionTest {

    @Test
    void should_stop_run_when_quit() {
        SystemEnvironment.startSystem();

        Response response = QuitOption.doAction();

        assertEquals(ResponseStatus.OK, response.getStatue());
        assertFalse(SystemEnvironment.isRun);
    }

}