package Action.Options;

import Controller.SystemEnvironment;
import Data.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListBooksOptionTest {

    @Test
    void should_list_all_books() {
        SystemEnvironment.startSystem();

        Response response = new ListBooksOption(null).doAction(null);

        String except = "---------------------------------------------------------------------------------------------------------------------\n" +
                "|Book Id     |Book name                                         |Author                   |Year Published           |\n" +
                "---------------------------------------------------------------------------------------------------------------------\n" +
                "|2200801     |Compilers: Principles, Techniques, and Tools      |Alfred V.Aho             |2008                      |\n" +
                "|2200001     |Design Patterns                                   |Erich Gamma              |2000                      |\n" +
                "|2200101     |The C Programming Language                        |Dennis                   |2001                      |\n" +
                "|2201001     |Code                                              |Charles Petzold          |2010                      |\n" +
                "|2200601     |Introduction to Algorithms                        |Thomas                   |2006                      |\n" +
                "---------------------------------------------------------------------------------------------------------------------\n";

        assertEquals(except, response.getMessage());
    }

}