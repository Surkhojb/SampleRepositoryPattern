package com.example.surkhojb.samplerepositorypattern.ui.users;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.surkhojb.samplerepositorypattern.MyApplication;
import com.example.surkhojb.samplerepositorypattern.R;
import com.example.surkhojb.samplerepositorypattern.data.repository.AppRepository;
import com.example.surkhojb.samplerepositorypattern.domain.Comment;
import com.example.surkhojb.samplerepositorypattern.domain.Post;
import com.example.surkhojb.samplerepositorypattern.domain.User;
import com.example.surkhojb.samplerepositorypattern.ui.comments.CommentsAdapter;
import com.example.surkhojb.samplerepositorypattern.ui.posts.PostAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailActivity extends AppCompatActivity {
    public final static String INTENT_EXTRA_USER = "user_detail";

    private TextView userName,userEmail,userPhone,userWebsite;
    private TextView touchToLoad;
    private ProgressBar loadingIndicator;
    private RecyclerView rvUserComments;
    private PostAdapter postAdapter;
    private User userDetail;

    public static void start(Activity activity, User user){
        Intent intent = new Intent(activity,UserDetailActivity.class);
        intent.putExtra(INTENT_EXTRA_USER, user);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        userDetail = (User) getIntent().getSerializableExtra(INTENT_EXTRA_USER);

        initView();
        loadUserDetail(userDetail);


    }

    private View.OnClickListener touchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            touchToLoad.setVisibility(View.GONE);
            loadingIndicator.setVisibility(View.VISIBLE);
            AppRepository appRepository = MyApplication.getRepository();
            appRepository.getListOfPostsByUser(userDetail.getUserId())
                    .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        loadComments(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),R.string.error_loading_comments,Toast.LENGTH_SHORT).show();
                    }
                });
        }
    };

    private void loadComments(List<Post> items) {
        if(items != null && !items.isEmpty()){
            loadingIndicator.setVisibility(View.GONE);
            touchToLoad.setVisibility(View.GONE);
            postAdapter.setData(items);
            rvUserComments.setVisibility(View.VISIBLE);
        }else{
            loadingIndicator.setVisibility(View.GONE);
            touchToLoad.setText(R.string.no_comments_found);
            touchToLoad.setVisibility(View.VISIBLE);
            rvUserComments.setVisibility(View.GONE);
        }
    }

    private void loadUserDetail(User user){
        userName.setText(user.getUserName());
        userEmail.setText(user.getUserEmail());
        userPhone.setText(user.getPhone());
        userWebsite.setText(user.getWebSite());
    }

    private void initView() {
        userName = findViewById(R.id.user_detail_name);
        userEmail = findViewById(R.id.user_detail_email);
        userPhone =  findViewById(R.id.user_detail_phone);
        userWebsite = findViewById(R.id.user_detail_web);
        touchToLoad = findViewById(R.id.tv_load_comments);
        touchToLoad.setOnClickListener(touchClickListener);

        loadingIndicator = findViewById(R.id.loading_comments_indicator);
        rvUserComments = findViewById(R.id.rv_user_comments);
        rvUserComments.setLayoutManager(new LinearLayoutManager(this));
        rvUserComments.hasFixedSize();
        postAdapter = new PostAdapter();
        rvUserComments.setAdapter(postAdapter);
    }
}
