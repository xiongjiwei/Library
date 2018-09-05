package Action.Options;

import Data.Database;
import Data.Message.ResponseStatus;
import Data.ProductStatue;
import Data.Message.Response;

import java.time.LocalDate;

public class ReturnOption {
    public static Response doAction(String action) {
        int id;
        try {
            id = Integer.valueOf(action);
        } catch (NumberFormatException e) {
            return new Response(ResponseStatus.ILLEGAL, "Input valid id");
        }

        ProductStatue productStatue = Database.productStatueTable.get(id);

        if (productStatue == null || productStatue.isAvailable()) {
            return new Response(ResponseStatus.ILLEGAL, "Input valid id");
        }

        productStatue.setAvailable(true);
        productStatue.setReturnData(LocalDate.now());
        productStatue.setCheckoutCustomerName(null);

        return new Response(ResponseStatus.OK, "Thank you for returning the book(movie).");
    }
}
