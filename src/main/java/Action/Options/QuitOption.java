package Action.Options;

import Controller.SystemEnvironment;
import Data.Message.Response;
import Data.Message.ResponseStatus;

public class QuitOption {
    public static Response doAction() {

        SystemEnvironment.isRun = false;

        return new Response(ResponseStatus.OK, "");
    }
}
