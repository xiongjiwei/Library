package Action.Options;

import Data.Database;
import Data.Message.Response;
import Data.Message.ResponseStatus;

public class ListBooksOption {
    public static Response doAction() {

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

        return new Response(ResponseStatus.OK, stringBuilder.toString());
    }
}
