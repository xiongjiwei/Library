package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOutMovieOptionTest {
    @Test
    void should_login_when_not_login() {
        SystemEnvironment.startSystem();

        Response response = CheckOutMovieOption.doAction(null);

        assertEquals(ResponseStatus.NOTLOGIN, response.getStatue());
        assertEquals("Your are not login", response.getMessage());
    }

    @Test
    void should_checkout_successful() {
        SystemEnvironment.startSystem();
        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = "101-1089";

        Response response = CheckOutMovieOption.doAction("1199401");

        assertEquals(ResponseStatus.OK, response.getStatue());
        assertEquals("Thank you! Enjoy the movie.", response.getMessage());
        assertFalse(Database.productStatueTable.get(1199401).isAvailable());
    }

    @Test
    void should_show_wrong_message_when_input_is_illegal() {
        SystemEnvironment.startSystem();
        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = "101-1089";

        Response response = CheckOutMovieOption.doAction("fff");

        assertEquals(ResponseStatus.ILLEGAL, response.getStatue());
        assertEquals("Illegal movie id.", response.getMessage());
    }

}