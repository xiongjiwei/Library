package Action;

import Action.Options.OptionFactory;
import Data.Response;

import java.util.ArrayList;

public class ActionProcessor {
    public static ArrayList<OptionFactory> menu = new ArrayList<>();

    public static Response doSomeAction(String option, String message) {
        int index;
        try {
            index = Integer.valueOf(option);
        } catch (NumberFormatException e) {
            return new Response(1, "Select a valid option!");
        }
        if (0 == index || index > menu.size()) {
            return new Response(1, "Select a valid option!");
        }

        return menu.get(index - 1).doAction(message);
    }

    public static ArrayList<OptionFactory> getMenu() {
        return menu;
    }
}
