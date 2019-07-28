package com.example22.lenovo.admin.notif;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {



    private static Retrofit retrofit = null ;


    public static Retrofit getClient(String url){


        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(url)
                    .client(getinterceptor())
                    .build();
        }

        return retrofit ;
    }


    public  static OkHttpClient getinterceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        return client ;
    }
}
