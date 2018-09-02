package Action.Options;

import Controller.SystemEnvironment;
import Data.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void should_login_when_username_and_password_is_right() {
        SystemEnvironment.startSystem();

        Response response = new Login(null).doAction("101-1089,tompwd");

        assertEquals("101-1089", SystemEnvironment.loginUser);
        assertTrue(SystemEnvironment.isLogin);
    }

    @Test
    void should_do_not_login_when_username_or_password_is_not_right() {
        SystemEnvironment.startSystem();

        new Login(null).doAction("101-1089,ompwd");

        assertNull(SystemEnvironment.loginUser);
        assertFalse(SystemEnvironment.isLogin);
    }
}