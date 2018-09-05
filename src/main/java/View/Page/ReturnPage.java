package View.Page;

import Action.Router;
import Data.Message.Request;
import Data.Message.RequestOption;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import View.AbstractPage;

import java.util.Scanner;

public class ReturnPage extends AbstractPage {

    public ReturnPage(String display) {
        super(display);
    }

    @Override
    public void showPage() {
        System.out.print("Input book(movie) id you want return");
        String id = new Scanner(System.in).nextLine();

        Request request = new Request(RequestOption.Return, id);
        Response response = Router.doSomeAction(request);

        if (response.getStatue() == ResponseStatus.ILLEGAL) {
            System.out.println("That is not a valid book(movie) to return.");
            return;
        }

        if (response.getStatue() == ResponseStatus.OK) {
            System.out.println("Thank you for returning the book(movie).");
        }
    }
}