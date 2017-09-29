package com.example.pranav.gitapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.pranav.gitapp.R;
import com.example.pranav.gitapp.Adapter.UserAdapter;
import com.example.pranav.gitapp.API.UserApi;
import com.example.pranav.gitapp.Model.UserList;
import com.example.pranav.gitapp.Model.Users;

import java.util.ArrayList;

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

        String getSearchedValue = getIntent().getStringExtra("SearchedValue");

        userList = (RecyclerView) findViewById(R.id.userList);

        GitAdapter = new UserAdapter(userArrayList,this);

        UserApi userApi = new UserApi();
        userApi.getUserListGET().getUserList(getSearchedValue).enqueue(new Callback<UserList>() {
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
