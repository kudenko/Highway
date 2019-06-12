package trello;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import trello.models.TrelloList;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrelloApi {
    public static final String KEY = "f8c73e0ff5efa5125a325a97ce8b94ed";
    public static final String TOKEN = "bfaa10061c37c49c9ad4f5a48152348202026df079a8c8d6bbe80f22d04cf7b1";
    //8c83f9dd3e9ac62d1149339352602e7c

    Gson gson = new Gson();

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    public List<TrelloList> getBoardsLists(String boardId) throws IOException {
        Request request = new Request.Builder().url("https://api.trello.com/1/boards/" + boardId +
                "/lists?cards=all&card_fields=all&filter=open&fields=all&key=" + KEY + "&token=" + TOKEN).build();
        String response = client.newCall(request).execute().body().string();

        Type type = new TypeToken<List<TrelloList>>(){}.getType();
        List<TrelloList> trelloLists = gson.fromJson(response, type);

        return trelloLists;

        //'https://api.trello.com/1/boards/id/lists?cards=none&card_fields=all&filter=open&fields=all'
    }

    public void createCard(String listId, Card card) throws IOException {
        String json = gson.toJson(card);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?idList="+listId + "&keepFromSource=all&key="+KEY+"&token="+TOKEN)
                .post(requestBody)
                .build();
        //https://api.trello.com/1/cards?idList=idList&keepFromSource=all
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void createList(String boardId, TrelloList trello) throws IOException {
        String json = gson.toJson(trello);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/lists?idBoard="+boardId+"&key="+KEY+"&token="+TOKEN)
                .post(requestBody)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);

        //https://api.trello.com/1/lists?name=nnn&idBoard=IdBoard&idListSource=list&pos=pos
    }
}