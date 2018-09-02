package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Response;
import Data.User;

public class Login extends OptionFactory {
    public Login(String option) {
        super(option);
    }

    @Override
    public Response doAction(String action) {
        if (action == null) {
            return new Response(101, "");
        }

        String[] token = action.split(",");

        User user = Database.userTable.get(token[0]);
        if (user == null || !user.getPassword().equals(token[1])) {
            return new Response(101, "Wrong user number or password");
        }

        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = token[0];

        return new Response(200, "");
    }
}
