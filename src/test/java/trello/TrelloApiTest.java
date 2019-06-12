package trello;

import org.testng.annotations.Test;
import trello.models.TrelloList;

import java.io.IOException;
import java.util.List;

public class TrelloApiTest {
    @Test
    public void go() throws IOException {
        TrelloApi trelloApi = new TrelloApi();
        List<TrelloList> boards =  trelloApi.getBoardsLists("Ad39BPpI");
        for(TrelloList board:boards) {
            Card card = new Card();
            card.name = "Card " + board.name;
            card.desc = "Cool desc";
            trelloApi.createCard(board.id, card);
            TrelloList test = new TrelloList();
            test.name = "name1234";
            trelloApi.createList(board.idBoard, test);
        }

    }
}