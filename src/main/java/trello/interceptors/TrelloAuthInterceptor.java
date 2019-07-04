package trello.interceptors;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by lolik on 03.02.17.
 */
public class TrelloAuthInterceptor implements Interceptor {


    private static final String KEY = "f8c73e0ff5efa5125a325a97ce8b94ed";
    private static final String TOKEN = "bfaa10061c37c49c9ad4f5a48152348202026df079a8c8d6bbe80f22d04cf7b1";


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("key", KEY)
                .addQueryParameter("token", TOKEN)
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }


}