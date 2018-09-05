package Action.Options;

import Controller.SystemEnvironment;
import Data.Database;
import Data.Message.ResponseStatus;
import Data.Movie;
import Data.Message.Response;

import java.time.LocalDate;

public class CheckOutMovieOption {
    public static Response doAction(String action) {
        if (!SystemEnvironment.isLogin) {
            return new Response(ResponseStatus.NOTLOGIN, "Your are not login");
        }

        if (action == null) {
            return new Response(ResponseStatus.CONTINUE, "Movie id is required");
        }

        int id;
        try {
            id = Integer.valueOf(action);
        } catch (NumberFormatException e) {
            return new Response(ResponseStatus.ILLEGAL, "Illegal movie id.");
        }

        Movie movie = Database.movieTable.get(id);

        if (movie == null || !Database.productStatueTable.get(movie.getId()).isAvailable()) {
            return new Response(ResponseStatus.NOTAVAILABLE, "That movie is not available.");
        }

        Database.productStatueTable.get(movie.getId()).setAvailable(false);
        Database.productStatueTable.get(movie.getId()).setCheckoutCustomerName(SystemEnvironment.loginUser);
        Database.productStatueTable.get(movie.getId()).setCheckoutDate(LocalDate.now());

        return new Response(ResponseStatus.OK, "Thank you! Enjoy the movie.");
    }
}
