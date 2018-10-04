package com.example.surkhojb.samplerepositorypattern.data.remote;

import com.example.surkhojb.samplerepositorypattern.domain.Album;
import com.example.surkhojb.samplerepositorypattern.domain.Comment;
import com.example.surkhojb.samplerepositorypattern.domain.Photo;
import com.example.surkhojb.samplerepositorypattern.domain.Post;
import com.example.surkhojb.samplerepositorypattern.domain.Todo;
import com.example.surkhojb.samplerepositorypattern.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 24/9/18.
 */

public interface JsonPlaceHolderApi {

    @GET("/albums")
    Call<List<Album>> getListOfAlbums();

    @GET("/comments")
    Call<List<Comment>> getListOfComments();

    @GET("/photos")
    Call<List<Photo>> getListOfPhotos();

    @GET("/posts/")
    Call<List<Post>> getListOfPosts();

    @GET("/todos")
    Call<List<Todo>> getListOfTodos();

    @GET("/users")
    Call<List<User>> getListOfUsers();

    @GET("posts/")
    Call<List<Post>> getPotsByUser(@Query("userId") int userId);

}
