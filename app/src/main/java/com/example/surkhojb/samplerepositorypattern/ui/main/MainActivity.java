package com.example.surkhojb.samplerepositorypattern.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.surkhojb.samplerepositorypattern.R;
import com.example.surkhojb.samplerepositorypattern.ui.albums.AlbumsActivity;
import com.example.surkhojb.samplerepositorypattern.ui.comments.CommentsActivity;
import com.example.surkhojb.samplerepositorypattern.ui.photos.PhotosActivity;
import com.example.surkhojb.samplerepositorypattern.ui.posts.PostsActivity;
import com.example.surkhojb.samplerepositorypattern.ui.todos.TodosActivities;
import com.example.surkhojb.samplerepositorypattern.ui.users.UsersActivity;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 21/9/18.
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadPosts(View view) {
        loadActivity(PostsActivity.class);
    }

    public void loadUsers(View view) {
        loadActivity(UsersActivity.class);
    }

    public void loadAlbums(View view) {
        loadActivity(AlbumsActivity.class);
    }

    public void loadComments(View view) {
        loadActivity(CommentsActivity.class);
    }

    public void loadPhotos(View view) {
        loadActivity(PhotosActivity.class);
    }

    public void loadTodos(View view) {
        loadActivity(TodosActivities.class);
    }

    private void loadActivity(Class activity){
        startActivity(new Intent(this,activity));
    }

}
