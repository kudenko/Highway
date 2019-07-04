package trello.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import trello.models.Board;
import trello.models.TrelloList;

import java.util.List;

public interface BoardsService {
    @GET("boards/{boardId}/lists")
    Call<List<TrelloList>> getLists(@Path("boardId")String boardId);

    //standart
    //Call<ResponseBody>

    //Call<List<TrelloList>>

    @POST("boards")
    Call<Board> createBoard(@Query("name") String name);

    @DELETE("boards/{id}")
    Call<ResponseBody> deleteBoard(@Path("id")String id);

    @PUT("boards/{id}")
    Call<Board> updateBoard(@Path("id")String id, @Body Board board);
}
