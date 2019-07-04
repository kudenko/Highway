package trello;

import org.testng.annotations.Test;
import trello.models.Board;
import trello.models.TrelloList;

import java.io.IOException;
import java.util.List;

public class TrelloApiTest {
    @Test
    public void go() throws IOException {
        TrelloApi trelloApi = new TrelloApi();
//        List<TrelloList> boards =  trelloApi.getBoardsLists("Ad39BPpI");
//        for(TrelloList board:boards) {
//            Card card = new Card();
//            card.name = "Card " + board.name;
//            card.desc = "Cool desc";
//            trelloApi.createCard(board.id, card);
//            TrelloList test = new TrelloList();
//            test.name = "name1234";
//            trelloApi.createList(board.idBoard, test);

        //}
        trelloApi.getBoardsLists("Ad39BPpI");

    }

    TrelloRestClient client = new TrelloRestClient();

    @Test
    public void adasda() throws IOException {

        List<TrelloList> body = client.boardsService.getLists("Ad39BPpI").execute().body();
        body.forEach(t -> System.out.println(t.name));

    }



    @Test
    public void createBoard() throws IOException, InterruptedException {
        Board board = client.boardsService.createBoard("Lolik 25").execute().body();
        board.desc = "ASDASDDSADASSDASDASASDDASDAS";
        client.boardsService.updateBoard(board.id, board).execute();

    }
}
