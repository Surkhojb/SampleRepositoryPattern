package com.example.surkhojb.samplerepositorypattern;

import android.app.Application;

import com.example.surkhojb.samplerepositorypattern.data.remote.JsonPlaceHolderApi;
import com.example.surkhojb.samplerepositorypattern.data.remote.RetrofitPlaceHolderService;
import com.example.surkhojb.samplerepositorypattern.data.repository.AppRepository;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 21/9/18.
 */

public class MyApplication extends Application {
    private static AppRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
       repository =  new AppRepository();

    }

    public static AppRepository getRepository(){
        return repository;
    }
}
