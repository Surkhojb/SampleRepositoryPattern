package com.example.surkhojb.samplerepositorypattern.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 24/9/18.
 */

public class RetrofitPlaceHolderService {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public RetrofitPlaceHolderService() {

    }

    public JsonPlaceHolderApi createService(){
        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(JsonPlaceHolderApi.class);

    }
}
