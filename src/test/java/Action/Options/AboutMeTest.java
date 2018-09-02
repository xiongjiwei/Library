package Action.Options;

import Controller.SystemEnvironment;
import Data.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AboutMeTest {

    @Test
    void should_show_my_information() {
        SystemEnvironment.startSystem();
        loginWithTom();

        Response response = new AboutMe(null).doAction(null);
        String except = "Here is your information:\n" +
                "ID:           101-1089\n" +
                "Name:         Tom\n" +
                "Email:        tom@gmail.com\n" +
                "Phone Number: 010-7864123";

        assertEquals(200, response.getStatue());
        assertEquals(except, response.getMessage());
    }

    @Test
    void should_show_wrong_message_when_not_login() {
        SystemEnvironment.startSystem();

        Response response = new AboutMe(null).doAction(null);

        String except = "You are not login";

        assertEquals(200, response.getStatue());
        assertEquals(except, response.getMessage());
    }

    private static void loginWithTom() {
        SystemEnvironment.loginUser = "101-1089";
        SystemEnvironment.isLogin = true;
    }

}