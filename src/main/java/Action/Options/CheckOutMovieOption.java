package Action.Options;

import Controller.SystemEnvironment;
import Data.Book;
import Data.Database;
import Data.Movie;
import Data.Response;

import java.time.LocalDate;

public class CheckOutMovieOption extends OptionFactory {

    public CheckOutMovieOption(String option) {
        super(option);
    }

    @Override
    public Response doAction(String action) {
        if (!SystemEnvironment.isLogin) {
            return new Response(200, "Your need login to checkout movies");
        }

        if (action == null) {
            return new Response(100, "Input the movie id you want checkout");
        }

        int index;
        try {
            index = Integer.valueOf(action);
        } catch (NumberFormatException e) {
            return new Response(200, "That movie is not available.");
        }

        Movie movie = Database.movieTable.get(index);

        if (movie == null || !Database.productStatueTable.get(movie.getId()).isAvailable()) {
            return new Response(200, "That movie is not available.");
        }

        Database.productStatueTable.get(movie.getId()).setAvailable(false);
        Database.productStatueTable.get(movie.getId()).setCheckoutCustomerName(SystemEnvironment.loginUser);
        Database.productStatueTable.get(movie.getId()).setCheckoutDate(LocalDate.now());

        return new Response(200, "Thank you! Enjoy the movie.");
    }
}
