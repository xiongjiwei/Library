package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOutBookOptionTest {

    @Test
    void should_login_when_not_login() {
        SystemEnvironment.startSystem();

        Response response = new CheckOutBookOption(null).doAction(null);

        assertEquals(200, response.getStatue());
        assertEquals("Your need login to checkout books", response.getMessage());
    }

    @Test
    void should_checkout_successful() {
        SystemEnvironment.startSystem();
        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = "101-1089";

        Response response = new CheckOutBookOption(null).doAction("2200801");

        assertEquals(200, response.getStatue());
        assertEquals("Thank you! Enjoy the book.", response.getMessage());
        assertFalse(Database.productStatueTable.get(2200801).isAvailable());
    }

    @Test
    void should_show_wrong_message_when_input_is_illegal() {
        SystemEnvironment.startSystem();
        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = "101-1089";

        Response response = new CheckOutBookOption(null).doAction("fff");

        assertEquals(200, response.getStatue());
        assertEquals("That book is not available.", response.getMessage());
    }

}