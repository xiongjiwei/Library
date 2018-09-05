package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import Data.User;

public class Login {
    public static Response doAction(String action) {

        String[] token = action.trim().split(",", 2);

        User user = Database.userTable.get(token[0]);
        if (user == null || !user.getPassword().equals(token[1])) {
            return new Response(ResponseStatus.REQUIRETOKEN, "Wrong user number or password");
        }

        SystemEnvironment.isLogin = true;
        SystemEnvironment.loginUser = token[0];

        return new Response(ResponseStatus.OK, "");
    }
}
