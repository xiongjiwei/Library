package Action.Options;

import Controller.SystemEnvironment;
import Data.Book;
import Data.Database;
import Data.Response;

import java.time.LocalDate;

public class CheckOutBookOption extends OptionFactory {

    public CheckOutBookOption(String option) {
        super(option);
    }

    @Override
    public Response doAction(String action) {
        if (!SystemEnvironment.isLogin) {
            return new Response(200, "Your need login to checkout books");
        }

        if (action == null) {
            return new Response(100, "Input the book id you want checkout: ");
        }

        int id;
        try {
            id = Integer.valueOf(action);
        } catch (NumberFormatException e) {
            return new Response(200, "That book is not available.");
        }

        Book book = Database.bookTable.get(id);

        if (book == null || !Database.productStatueTable.get(book.getId()).isAvailable()) {
            return new Response(200, "That book is not available.");
        }

        Database.productStatueTable.get(book.getId()).setAvailable(false);
        Database.productStatueTable.get(book.getId()).setCheckoutCustomerName(SystemEnvironment.loginUser);
        Database.productStatueTable.get(book.getId()).setCheckoutDate(LocalDate.now());

        return new Response(200, "Thank you! Enjoy the book.");
    }
}
