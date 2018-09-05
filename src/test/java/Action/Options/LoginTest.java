package Action.Options;

import Controller.SystemEnvironment;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void should_login_when_username_and_password_is_right() {
        SystemEnvironment.startSystem();

        Response response = Login.doAction("101-1089,tompwd");

        assertEquals(ResponseStatus.OK, response.getStatue());
        assertEquals("101-1089", SystemEnvironment.loginUser);
        assertTrue(SystemEnvironment.isLogin);
    }

    @Test
    void should_do_not_login_when_username_or_password_is_not_right() {
        SystemEnvironment.startSystem();

        Response response = Login.doAction("101-1089,ompwd");

        assertEquals(ResponseStatus.REQUIRETOKEN, response.getStatue());
        assertNull(SystemEnvironment.loginUser);
        assertFalse(SystemEnvironment.isLogin);
    }
}