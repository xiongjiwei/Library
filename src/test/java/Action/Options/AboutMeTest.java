package Action.Options;

import Controller.SystemEnvironment;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AboutMeTest {

    @Test
    void should_show_my_information() {
        SystemEnvironment.startSystem();
        loginWithTom();

        Response response = AboutMe.doAction();
        String except = "Here is your information:\n" +
                "ID:           101-1089\n" +
                "Name:         Tom\n" +
                "Email:        tom@gmail.com\n" +
                "Phone Number: 010-7864123";

        assertEquals(ResponseStatus.OK, response.getStatue());
        assertEquals(except, response.getMessage());
    }

    @Test
    void should_show_wrong_message_when_not_login() {
        SystemEnvironment.startSystem();

        Response response = AboutMe.doAction();

        String except = "You are not login";

        assertEquals(ResponseStatus.NOTLOGIN, response.getStatue());
        assertEquals(except, response.getMessage());
    }

    private static void loginWithTom() {
        SystemEnvironment.loginUser = "101-1089";
        SystemEnvironment.isLogin = true;
    }

}