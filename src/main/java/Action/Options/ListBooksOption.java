package Action.Options;

import Data.Database;
import Data.Response;

public class ListBooksOption extends OptionFactory{

    public ListBooksOption(String option) {
        super(option);
    }

    @Override
    public Response doAction(String action) {

        StringBuilder stringBuilder = new StringBuilder(512);
        stringBuilder.append("---------------------------------------------------------------------------------------------------------------------\n")
                     .append("|Book Id     |Book name                                         |Author                   |Year Published           |\n")
                     .append("---------------------------------------------------------------------------------------------------------------------\n");


        Database.bookTable.forEach((id, book) -> {
            if (Database.productStatueTable.get(id).isAvailable()) {
                stringBuilder.append(String.format("|%-12d|%-50s|%-25s|%-26d|\n",book.getId(), book.getName(), book.getAuthor(), book.getYearPublished()));
            }
        });

        stringBuilder.append("---------------------------------------------------------------------------------------------------------------------\n");

        return new Response(200, stringBuilder.toString());
    }
}
