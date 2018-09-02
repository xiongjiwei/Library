package Action.Options;

import Data.Database;
import Data.Response;

public class ListMovieOption extends OptionFactory {

    public ListMovieOption(String option) {
        super(option);
    }

    @Override
    public Response doAction(String action) {
        StringBuilder stringBuilder = new StringBuilder(512);
        stringBuilder.append("------------------------------------------------------------------------------------------------------------------------------\n")
                     .append("|Movie Id     |Movie name                                                  |Director                   |Year    |Rate        |\n")
                     .append("------------------------------------------------------------------------------------------------------------------------------\n");


        Database.movieTable.forEach((id, movie) -> {
            if (Database.productStatueTable.get(id).isAvailable()) {
                stringBuilder.append(String.format("|%-13d|%-60s|%-27s|%-8d|%-12d|\n",movie.getId(), movie.getName(), movie.getDirector(), movie.getYear(), movie.getRating()));
            }
        });

        stringBuilder.append("------------------------------------------------------------------------------------------------------------------------------\n");

        return new Response(200, stringBuilder.toString());
    }
}
