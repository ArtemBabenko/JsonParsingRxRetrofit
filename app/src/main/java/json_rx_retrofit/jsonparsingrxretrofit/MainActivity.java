package json_rx_retrofit.jsonparsingrxretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import json_rx_retrofit.jsonparsingrxretrofit.models.Message;
import json_rx_retrofit.jsonparsingrxretrofit.network.MessagesApi;
import json_rx_retrofit.jsonparsingrxretrofit.network.SingleRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadDataRx(SingleRetrofit.getInstance().createRxApiSample());

    }

    // TODO: Стандартное использование Retrofit.
//    private void downloadData(MessagesApi messagesApi) {
//
//        Call<List<Message>> messages = messagesApi.messages();
//
//        messages.enqueue(new Callback<List<Message>>() {
//            @Override
//            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
//                if (response.isSuccessful()) {
//                    for (Message message : response.body()) {
//                        Log.d(TAG, "response Id:" + message.getId() + " Mess:" + message.getText() + " Time:" + message.getTime());
//                    }
//
//                } else {
//                    Log.d(TAG, "response code " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Message>> call, Throwable t) {
//                Log.d(TAG, "failure " + t);
//            }
//        });
//    }

    // TODO: Использование Retrofit с помощью RxJava.
    private void downloadDataRx(MessagesApi messagesApi) {
        messagesApi.messages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Message>>() {
                    @Override
                    public void onSuccess(@NonNull List<Message> messages) {
                        for (Message message : messages) {
                            Log.d(TAG, "response Id:" + message.getId() + " Mess:" + message.getText() + " Time:" + message.getTime());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "failure " + e);
                    }
                });
    }

    // TODO: Метод messages вернет нам Single<List<Messages>>, на который мы подписываемся и настраиваем, чтобы запрос был выполнен в IO потоке, а результат вернулся в UI потоке.
    // TODO: В случае использования RxJava, у нас уже нет объекта Response. И если сервер вернет какую-то ошибку, то мы получим ее в onError.

}
