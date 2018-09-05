package Action.Options;

import Controller.SystemEnvironment;
import Data.Message.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListMovieOptionTest {

    @Test
    void should_list_all_movies() {
        SystemEnvironment.startSystem();

        Response response = ListMovieOption.doAction();

        String except = "------------------------------------------------------------------------------------------------------------------------------\n" +
                "|Movie Id     |Movie name                                                  |Director                   |Year    |Rate        |\n" +
                "------------------------------------------------------------------------------------------------------------------------------\n" +
                "|1199301      |Farewell My Concubine                                       |Kaige Chen                 |1993    |9           |\n" +
                "|1200202      |Ice Age                                                     |Carlos Saldanha            |2002    |8           |\n" +
                "|1199401      |The Shawshank Redemption                                    |Frank Darabont             |1994    |9           |\n" +
                "|1200201      |The Lord of the Rings: The Two Towers                       |Peter Jackson              |2002    |9           |\n" +
                "|1199101      |The Silence of the Lambs                                    |Jonathan Demme             |1991    |8           |\n" +
                "------------------------------------------------------------------------------------------------------------------------------\n";

        assertEquals(except, response.getMessage());
    }

}