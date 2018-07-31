package json_rx_retrofit.jsonparsingrxretrofit.app;

import android.app.Application;
import json_rx_retrofit.jsonparsingrxretrofit.network.SingleRetrofit;

// TODO: Создание класса MyApp который наследует Application для иницмиализации Singleton. Будет приявязан к классу который точно запустится один раз.
// TODO: не забываем прописывать его в манифесте.

public class MyApp extends Application {

    public void onCreate(){
        super.onCreate();

        SingleRetrofit.initInstance();
    }
}
