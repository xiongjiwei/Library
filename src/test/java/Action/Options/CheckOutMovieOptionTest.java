package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOutMovieOptionTest {
    @Test
    void should_login_when_not_login() {
        SystemEnvironment.startSystem();

        Response response = new CheckOutMovieOption(null).doAction(null);

        assertEquals(200, response.getStatue());
        assertEquals("Your need login to checkout movies", response.getMessage());
    }

    @Test
    void should_checkout_successful() {
        SystemEnvironment.startSystem();
        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = "101-1089";

        Response response = new CheckOutMovieOption(null).doAction("1199401");

        assertEquals(200, response.getStatue());
        assertEquals("Thank you! Enjoy the movie.", response.getMessage());
        assertFalse(Database.productStatueTable.get(1199401).isAvailable());
    }

    @Test
    void should_show_wrong_message_when_input_is_illegal() {
        SystemEnvironment.startSystem();
        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = "101-1089";

        Response response = new CheckOutMovieOption(null).doAction("fff");

        assertEquals(200, response.getStatue());
        assertEquals("That movie is not available.", response.getMessage());
    }

}