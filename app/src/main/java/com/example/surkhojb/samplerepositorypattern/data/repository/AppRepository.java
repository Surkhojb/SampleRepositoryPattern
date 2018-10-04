package com.example.surkhojb.samplerepositorypattern.data.repository;

import com.example.surkhojb.samplerepositorypattern.data.remote.JsonPlaceHolderApi;
import com.example.surkhojb.samplerepositorypattern.data.remote.RetrofitPlaceHolderService;
import com.example.surkhojb.samplerepositorypattern.domain.Comment;
import com.example.surkhojb.samplerepositorypattern.domain.Post;
import com.example.surkhojb.samplerepositorypattern.domain.User;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 26/9/18.
 */

public class AppRepository {
    private JsonPlaceHolderApi remoteSource;

    public AppRepository() {
        this.remoteSource = RetrofitPlaceHolderService.getInstance().getService();
    }

    public Call<List<Post>> getListOfPosts() {
        return remoteSource.getListOfPosts();
    }

    public Call<List<User>> getListOfUsers() {
        return remoteSource.getListOfUsers();
    }

    public Call<List<Post>> getListOfPostsByUser(int userId) {
        return remoteSource.getPotsByUser(userId);
    }
}
