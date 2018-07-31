package json_rx_retrofit.jsonparsingrxretrofit.network;

import java.util.List;

import io.reactivex.Single;
import json_rx_retrofit.jsonparsingrxretrofit.models.Message;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MessagesApi {

    // TODO: Стандартное использование Retrofit.
//    @GET("messages1.json")
//    Call<List<Message>> messages();

    // TODO: Использование Retrofit с помощью RxJava
    @GET("messages1.json")
    Single<List<Message>> messages();

    // TODO: Вместо обертки Call мы используем Single из RxJava. Он вернет нам либо результат (onNext), либо ошибку (onError). А метод завершения (onCompleted) он вызывать не будет.
}
