package View;

import Controller.SystemEnvironment;

import java.util.Scanner;

public class MainPage {
    public void run() {
        showWelcome();
        System.out.println("###############################################################################");

        while (SystemEnvironment.isRun) {
            showMenu();
            selectOption();
        }
    }

    private void selectOption() {
        String action = new Scanner(System.in).nextLine();

        int option = 0;
        try {
            option = Integer.valueOf(action);
        } catch (NumberFormatException ignored) {
        }

        if (option <= 0 || option > SystemEnvironment.menu.size()) {
            System.out.println("Select a valid option!");
            return;
        }

        SystemEnvironment.menu.get(option - 1).showPage();
    }

    private void showMenu() {
        System.out.println("============================================================================");
        for (int i = 0; i < SystemEnvironment.menu.size(); i++) {
            System.out.println(i + 1 + "." + SystemEnvironment.menu.get(i).getDisplayName());
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
