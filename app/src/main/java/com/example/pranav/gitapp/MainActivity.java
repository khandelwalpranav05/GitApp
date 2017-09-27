package com.example.pranav.gitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

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
        userApi.getUserListGET().getUserList().enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                for(Users user : response.body().getItems() ){
                    user.getLogin();
                    user.getAvatar();
                    userArrayList.add(user);
                }
                GitAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

                Log.e("OnFailure","Didn't work");
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        userList.setLayoutManager(layoutManager);
        userList.setAdapter(GitAdapter);
    }


}
