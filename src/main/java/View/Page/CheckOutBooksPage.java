package View.Page;

import Action.Router;
import Data.Message.Request;
import Data.Message.RequestOption;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import View.AbstractPage;

import java.util.Scanner;

public class CheckOutBooksPage extends AbstractPage {

    public CheckOutBooksPage(String display) {
        super(display);
    }

    @Override
    public void showPage() {
        System.out.print("Input book id you want checkout");
        String bookId = new Scanner(System.in).nextLine();

        Request request = new Request(RequestOption.CheckoutBook, bookId);
        Response response = Router.doSomeAction(request);

        if (response.getStatue() == ResponseStatus.NOTLOGIN) {
            System.out.println("Your are not login.");
            return;
        }

        if (response.getStatue() == ResponseStatus.ILLEGAL) {
            System.out.println("illegal book id.");
            return;
        }

        if (response.getStatue() == ResponseStatus.NOTAVAILABLE) {
            System.out.println("That book is not available.");
            return;
        }

        if (response.getStatue() == ResponseStatus.OK) {
            System.out.println("Thank you! Enjoy the book.");
        }

    }
}
