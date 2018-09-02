package Action.Options;

import Data.Database;
import Data.ProductStatue;
import Data.Response;

import java.time.LocalDate;

public class ReturnOption extends OptionFactory {

    public ReturnOption(String option) {
        super(option);
    }

    @Override
    public Response doAction(String action) {
        if (action == null) {
            return new Response(100, "Input book(movie) id you want return");
        }

        int id;
        try {
            id = Integer.valueOf(action);
        } catch (NumberFormatException e) {
            return new Response(100, "Input valid id");
        }

        ProductStatue productStatue = Database.productStatueTable.get(id);

        if (productStatue == null || productStatue.isAvailable()) {
            return new Response(100, "Input valid id");
        }

        productStatue.setAvailable(true);
        productStatue.setReturnData(LocalDate.now());
        productStatue.setCheckoutCustomerName(null);

        return new Response(200, "Thank you for returning the book(movie).");
    }
}
