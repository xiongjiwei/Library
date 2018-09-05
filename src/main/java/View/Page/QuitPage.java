package View.Page;

import Action.Router;
import Data.Message.Request;
import Data.Message.RequestOption;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import View.AbstractPage;

public class QuitPage extends AbstractPage {
    public QuitPage(String display) {
        super(display);
    }

    @Override
    public void showPage() {
        Request request = new Request(RequestOption.Quit);

        Response response = Router.doSomeAction(request);

        if (response.getStatue() == ResponseStatus.OK) {
            System.out.println("Bye!");
        }
    }
}
