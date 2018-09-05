package View.Page;

import Action.Router;
import Data.Message.Request;
import Data.Message.RequestOption;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import View.AbstractPage;

import java.util.Scanner;

public class LoginPage extends AbstractPage {
    public LoginPage(String display) {
        super(display);
    }

    @Override
    public void showPage() {
        System.out.print("Input your user number: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Input your password: ");
        String pwd = new Scanner(System.in).nextLine();

        Request request = new Request(RequestOption.Login, name +"," + pwd);
        Response response = Router.doSomeAction(request);

        if (response.getStatue() == ResponseStatus.REQUIRETOKEN) {
            System.out.println("Wrong username or password");
            return;
        }

        if (response.getStatue() == ResponseStatus.OK) {
            System.out.println("Login success");
        }
    }
}
