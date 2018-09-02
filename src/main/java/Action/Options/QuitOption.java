package Action.Options;

import Controller.SystemEnvironment;
import Data.Response;

public class QuitOption extends OptionFactory {

    public QuitOption(String option) {
        super(option);
    }

    @Override
    public Response doAction(String action) {

        SystemEnvironment.isRun = false;

        return new Response(200, "");
    }
}
