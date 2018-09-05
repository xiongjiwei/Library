package Action.Options;

import Controller.SystemEnvironment;
import Data.Book;
import Data.Database;
import Data.Message.Response;
import Data.Message.ResponseStatus;

import java.time.LocalDate;

public class CheckOutBookOption {

    public static Response doAction(String action) {
        if (!SystemEnvironment.isLogin) {
            return new Response(ResponseStatus.NOTLOGIN, "Your are not login");
        }

        int id;
        try {
            id = Integer.valueOf(action);
        } catch (NumberFormatException e) {
            return new Response(ResponseStatus.ILLEGAL, "illegal book id.");
        }

        Book book = Database.bookTable.get(id);

        if (book == null || !Database.productStatueTable.get(book.getId()).isAvailable()) {
            return new Response(ResponseStatus.NOTAVAILABLE, "That book is not available.");
        }

        Database.productStatueTable.get(book.getId()).setAvailable(false);
        Database.productStatueTable.get(book.getId()).setCheckoutCustomerName(SystemEnvironment.loginUser);
        Database.productStatueTable.get(book.getId()).setCheckoutDate(LocalDate.now());

        return new Response(ResponseStatus.OK, "Thank you! Enjoy the book.");
    }
}
