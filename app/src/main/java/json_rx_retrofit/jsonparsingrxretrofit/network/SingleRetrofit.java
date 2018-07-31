package json_rx_retrofit.jsonparsingrxretrofit.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// TODO: Описание создание запроса с помощью Retrofit в отдельном  классе под патерном Singleton

public class SingleRetrofit {

    private static SingleRetrofit instance;

    private SingleRetrofit() {}

    public static void initInstance() {
        if (instance==null){
            instance = new SingleRetrofit();
        }
    }

    public static SingleRetrofit getInstance(){
        return instance;
    }

    // TODO: Стандартное использование Retrofit.
//    public MessagesApi createApiSample() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://rawgit.com/startandroid/data/master/messages/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        MessagesApi messagesApi = retrofit.create(MessagesApi.class);
//        return messagesApi;
//    }

    // TODO: Использование Retrofit с помощью RxJava.
    public MessagesApi createRxApiSample(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rawgit.com/startandroid/data/master/messages/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MessagesApi messagesApi = retrofit.create(MessagesApi.class);
        return messagesApi;
    }

}
