package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReturnOptionTest {
    @Test
    void should_return_success_when_everything_is_ok() {
        SystemEnvironment.startSystem();

        Database.productStatueTable.get(2200801).setAvailable(false);

        Response response = new ReturnOption(null).doAction("2200801");

        assertEquals("Thank you for returning the book(movie).", response.getMessage());
    }

    @Test
    void should_show_wrong_message_when_input_is_illegal() {
        SystemEnvironment.startSystem();

        Database.productStatueTable.get(2200801).setAvailable(false);

        Response response = new ReturnOption(null).doAction("ff");

        assertEquals("Input valid id", response.getMessage());
    }
}