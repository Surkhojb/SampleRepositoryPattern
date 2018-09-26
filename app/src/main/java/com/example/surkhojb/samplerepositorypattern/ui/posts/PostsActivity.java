package com.example.surkhojb.samplerepositorypattern.ui.posts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.surkhojb.samplerepositorypattern.MyApplication;
import com.example.surkhojb.samplerepositorypattern.R;
import com.example.surkhojb.samplerepositorypattern.data.remote.JsonPlaceHolderApi;
import com.example.surkhojb.samplerepositorypattern.data.remote.RetrofitPlaceHolderService;
import com.example.surkhojb.samplerepositorypattern.data.repository.AppRepository;
import com.example.surkhojb.samplerepositorypattern.domain.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    private RecyclerView rvListPosts;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        initView();
        loadPostsFromRemote();
    }

    private void initView(){
        rvListPosts  = findViewById(R.id.rv_list_posts);
        rvListPosts.setHasFixedSize(true);
        rvListPosts.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter();
        rvListPosts.setAdapter(adapter);
    }

    private void loadPostsFromRemote(){
        AppRepository repository = MyApplication.getRepository();
        repository.getListOfPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //We set the adapter with the list from the response
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),R.string.error_loading_pots,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
