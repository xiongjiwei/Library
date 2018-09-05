package Action;

import Action.Options.*;
import Data.Message.Request;
import Data.Message.Response;
import Data.Message.ResponseStatus;

public class Router {
    public static Response doSomeAction(Request request) {
        switch (request.getOption()) {
            case Login:
                return Login.doAction(request.getMessage());
            case ListBooks:
                return ListBooksOption.doAction();
            case ListMovie:
                return ListMovieOption.doAction();
            case CheckoutBook:
                return CheckOutBookOption.doAction(request.getMessage());
            case CheckoutMovie:
                return CheckOutMovieOption.doAction(request.getMessage());
            case Return:
                return ReturnOption.doAction(request.getMessage());
            case AboutMe:
                return AboutMe.doAction();
            case Quit:
                return QuitOption.doAction();
            default:
                return new Response(ResponseStatus.OK, null);
        }
    }
}
