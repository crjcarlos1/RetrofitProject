package com.cralos.myretrofitproject.retrofitClient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofitInstance = null;
    private static OkHttpClient okHttpClient = null;

    private RetrofitClient() {
    }

    public static synchronized Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(45, TimeUnit.SECONDS)
                    .connectTimeout(45, TimeUnit.SECONDS)
                    .build();
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(EndPoints.URL_SERVER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofitInstance;
    }


}
