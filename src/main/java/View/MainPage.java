package View;

import Action.ActionProcessor;
import Controller.SystemEnvironment;
import Data.Response;

import java.util.Scanner;

public class MainPage {
    public void run() {

        showWelcome();
        System.out.println("###############################################################################");

        while (SystemEnvironment.isRun) {
            showMenu();
            String action = new Scanner(System.in).nextLine();
            Response response = ActionProcessor.doSomeAction(action, null);

            while (response.getStatue() == 100) {
                System.out.print(response.getMessage());
                String message = new Scanner(System.in).nextLine();
                response = ActionProcessor.doSomeAction(action, message);
            }

            while (response.getStatue() == 101) {
                System.out.println(response.getMessage());
                System.out.print("Input your user number: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Input your password: ");
                String pwd = new Scanner(System.in).nextLine();
                response = ActionProcessor.doSomeAction(action, name + "," + pwd);
            }

            System.out.println(response.getMessage());
        }
    }

    private void showMenu() {
        System.out.println("============================================================================");
        for (int i = 0; i < ActionProcessor.menu.size(); i++) {
            System.out.println(i + 1 + "." + ActionProcessor.menu.get(i).getOption());
        }
        System.out.println("****************************************************************************");
        System.out.print("Select an option: ");
    }

    private void showWelcome() {
        final String welcomeMsg =
                "              _                          \n" +
                        "__      _____| | ___ ___  _ __ ___   ___ \n" +
                        "\\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\\n" +
                        " \\ V  V /  __/ | (_| (_) | | | | | |  __/\n" +
                        "  \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|\n" +
                        "                                         ";

        System.out.println(welcomeMsg);
    }
}
