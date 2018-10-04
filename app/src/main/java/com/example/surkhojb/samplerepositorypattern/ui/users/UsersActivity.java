package com.example.surkhojb.samplerepositorypattern.ui.users;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.surkhojb.samplerepositorypattern.MyApplication;
import com.example.surkhojb.samplerepositorypattern.R;
import com.example.surkhojb.samplerepositorypattern.data.repository.AppRepository;
import com.example.surkhojb.samplerepositorypattern.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity implements UsersAdapterClick {
    private RecyclerView listOfUsers;
    private UsersAdapter usersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        initView();
        loadUsersFromRepo();

    }

    @Override
    public void onUserClicked(int position) {
        UserDetailActivity.start(this,usersAdapter.getUserAtPosition(position));
    }

    private void initView() {
        listOfUsers = findViewById(R.id.rv_list_users);
        listOfUsers.setLayoutManager(new LinearLayoutManager(this));
        listOfUsers.hasFixedSize();
        usersAdapter = new UsersAdapter();
        usersAdapter.setOnUserClickListener(this);
        listOfUsers.setAdapter(usersAdapter);
    }

    private void loadUsersFromRepo() {
        AppRepository appRepository = MyApplication.getRepository();
        appRepository.getListOfUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                usersAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),R.string.error_loading_users,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
