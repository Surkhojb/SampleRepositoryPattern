package com.example.surkhojb.samplerepositorypattern;

import android.app.Application;

import com.example.surkhojb.samplerepositorypattern.data.remote.RetrofitPlaceHolderService;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 21/9/18.
 */

public class MyApplication extends Application {
    private static RetrofitPlaceHolderService retrofitPlaceHolderService;

    @Override
    public void onCreate() {
        super.onCreate();
       retrofitPlaceHolderService =  RetrofitPlaceHolderService.getInstance();

    }

    public static RetrofitPlaceHolderService getRetrofitPlaceHolderService(){
        return retrofitPlaceHolderService;
    }
}
