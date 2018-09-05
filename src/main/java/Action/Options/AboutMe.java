package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Message.Response;
import Data.Message.ResponseStatus;
import Data.User;

public class AboutMe {
    public static Response doAction() {
        if (!SystemEnvironment.isLogin || !Database.userTable.containsKey(SystemEnvironment.loginUser)) {
            return new Response(ResponseStatus.NOTLOGIN, "You are not login");
        }

        User user = Database.userTable.get(SystemEnvironment.loginUser);

        String returnString = "Here is your information:" +
                "\nID:           " + user.getId() +
                "\nName:         " + user.getName() +
                "\nEmail:        " + user.getEmail() +
                "\nPhone Number: " + user.getPhoneNumber();

        return new Response(ResponseStatus.OK, returnString);
    }
}
