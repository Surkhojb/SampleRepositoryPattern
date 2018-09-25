package com.example.surkhojb.samplerepositorypattern.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 24/9/18.
 */

public class RetrofitPlaceHolderService {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static RetrofitPlaceHolderService INSTANCE = null;
    private static Retrofit retrofit;

    private RetrofitPlaceHolderService() {
        createService();
    }

    public static RetrofitPlaceHolderService getInstance(){

        if(null == INSTANCE){
            INSTANCE = new RetrofitPlaceHolderService();
        }

        return INSTANCE;
    }

    public void createService(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();

        Gson gson = new GsonBuilder().create();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(client)
                .build();
    }

    public JsonPlaceHolderApi getService(){
        return retrofit.create(JsonPlaceHolderApi.class);
    }
}
