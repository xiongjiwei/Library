package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOutBookOptionTest {

    @Test
    void should_login_when_not_login() {
        SystemEnvironment.startSystem();

        Response response = CheckOutBookOption.doAction(null);

        assertEquals(ResponseStatus.NOTLOGIN, response.getStatue());
        assertEquals("Your are not login", response.getMessage());
    }

    @Test
    void should_checkout_successful() {
        SystemEnvironment.startSystem();
        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = "101-1089";

        Response response = CheckOutBookOption.doAction("2200801");

        assertEquals(ResponseStatus.OK, response.getStatue());
        assertEquals("Thank you! Enjoy the book.", response.getMessage());
        assertFalse(Database.productStatueTable.get(2200801).isAvailable());
    }

    @Test
    void should_show_wrong_message_when_input_is_illegal() {
        SystemEnvironment.startSystem();
        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = "101-1089";

        Response response = CheckOutBookOption.doAction("fff");

        assertEquals(ResponseStatus.ILLEGAL, response.getStatue());
        assertEquals("illegal book id.", response.getMessage());
    }

}