package Controller;

import Data.*;
import View.AbstractPage;
import View.MainPage;
import View.Page.*;

import java.util.ArrayList;

public class SystemEnvironment {

    public static boolean isLogin = false;
    public static String loginUser = null;

    public static boolean isRun = false;
    public static ArrayList<AbstractPage> menu = new ArrayList<>();

    public static MainPage startSystem() {
        initUserTable();
        initBookTable();
        initMovieTable();
        initProductStatusTable();
        initMenu();

        isRun = true;
        isLogin = false;
        loginUser = null;

        return new MainPage();
    }
    private static void initMenu() {
        menu.add(new LoginPage("Login"));
        menu.add(new CheckOutBooksPage("Checkout Book"));
        menu.add(new CheckoutMoviePage("Checkout Movie"));
        menu.add(new ReturnPage("Return Products"));
        menu.add(new ListBooksPage("List Books"));
        menu.add(new ListMoviePage("List Movie"));
        menu.add(new AboutMePage("About Me"));
        menu.add(new QuitPage("Quit"));
    }

    private static void initBookTable() {
        Book[] books = new Book[] {
                new Book(2_2001_01, 2001, "The C Programming Language", "Dennis"),
                new Book(2_2010_01, 2010, "Code", "Charles Petzold"),
                new Book(2_2008_01, 2008, "Compilers: Principles, Techniques, and Tools", "Alfred V.Aho"),
                new Book(2_2006_01, 2006, "Introduction to Algorithms", "Thomas"),
                new Book(2_2000_01, 2000, "Design Patterns", "Erich Gamma"),
                };

        for (Book book : books) {
            Database.bookTable.put(book.getId(), book);
        }
    }


    private static void initUserTable() {
        String[][] userInfos = new String[][] {
                {"101-1089", "tompwd", "Tom", "tom@gmail.com", "010-7864123"},
                {"101-1056", "johnpwd", "John", "john@gmail.com", "13600988965"},
                {"113-4578", "alicepwd", "Alice", "alice@gmail.com", ""},
                {"105-0964", "bobpwd", "Bob", "bob@gmail.com", "139076543334"},
                {"001-0000", "admin", "admin", "admin@gmail.com", "000-0000000"}
        };

        for (String[] userInfo : userInfos) {
            Database.userTable.put(userInfo[0], new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4]));
        }


    }

    private static void initMovieTable() {
        Movie[] movies = new Movie[] {
                new Movie(1_1994_01, 1994, 9, "The Shawshank Redemption", "Frank Darabont"),
                new Movie(1_1993_01, 1993, 9, "Farewell My Concubine", "Kaige Chen"),
                new Movie(1_2002_01, 2002, 9, "The Lord of the Rings: The Two Towers", "Peter Jackson"),
                new Movie(1_1991_01, 1991, 8, "The Silence of the Lambs", "Jonathan Demme"),
                new Movie(1_2002_02, 2002, 8, "Ice Age", "Carlos Saldanha"),
                };

        for (Movie movie : movies) {
            Database.movieTable.put(movie.getId(), movie);
        }
    }

    private static void initProductStatusTable() {
        Database.bookTable.keySet().forEach(key -> Database.productStatueTable.put(key, new ProductStatue()));
        Database.movieTable.keySet().forEach(key -> Database.productStatueTable.put(key, new ProductStatue()));
    }
}
