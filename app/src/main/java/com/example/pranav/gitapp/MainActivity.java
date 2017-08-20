package com.example.pranav.gitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    UserAdapter GitAdapter;
    RecyclerView userList;
    ArrayList<Users> userArrayList = new ArrayList<Users>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = (RecyclerView) findViewById(R.id.userList);
        GitAdapter = new UserAdapter(userArrayList,this);

        UserApi userApi = new UserApi();
        userApi.getUserListGET().getUserList().enqueue(new Callback<ArrayList<Users>>() {
            @Override
            public void onResponse(Call<ArrayList<Users>> call, Response<ArrayList<Users>> response) {

                GitAdapter.setUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Users>> call, Throwable t) {

            }
        });

    }


}
