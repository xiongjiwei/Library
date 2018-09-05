package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReturnOptionTest {
    @Test
    void should_return_success_when_everything_is_ok() {
        SystemEnvironment.startSystem();

        Database.productStatueTable.get(2200801).setAvailable(false);

        Response response = ReturnOption.doAction("2200801");

        assertEquals(ResponseStatus.OK, response.getStatue());
    }

    @Test
    void should_get_illegal_statue_when_input_is_illegal() {
        SystemEnvironment.startSystem();

        Response response = ReturnOption.doAction("fff");
        assertEquals(ResponseStatus.ILLEGAL, response.getStatue());
    }

    @Test
    void should_get_illegal_statue_when_product_is_available() {
        SystemEnvironment.startSystem();

        Database.productStatueTable.get(2200801).setAvailable(true);
        Response response = ReturnOption.doAction("2200801");
        assertEquals(ResponseStatus.ILLEGAL, response.getStatue());
    }
}