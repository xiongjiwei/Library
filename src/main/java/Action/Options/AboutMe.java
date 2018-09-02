package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Response;
import Data.User;

public class AboutMe extends OptionFactory {

    public AboutMe(String option) {
        super(option);
    }

    @Override
    public Response doAction(String action) {
        if (!SystemEnvironment.isLogin || !Database.userTable.containsKey(SystemEnvironment.loginUser)) {
            return new Response(200, "You are not login");
        }

        User user = Database.userTable.get(SystemEnvironment.loginUser);

        StringBuilder returnString = new StringBuilder(256);
        returnString.append("Here is your information:")
                    .append("\nID:           ").append(user.getId())
                    .append("\nName:         ").append(user.getName())
                    .append("\nEmail:        ").append(user.getEmail())
                    .append("\nPhone Number: ").append(user.getPhoneNumber());


        return new Response(200, returnString.toString());
    }
}
