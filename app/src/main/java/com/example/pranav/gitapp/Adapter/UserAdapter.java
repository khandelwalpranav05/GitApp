package com.example.pranav.gitapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pranav.gitapp.Activities.MainActivity;
import com.example.pranav.gitapp.Activities.SingleUsernameActivity;
import com.example.pranav.gitapp.Model.Users;
import com.example.pranav.gitapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Pranav on 20-08-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    ArrayList<Users> user;
    Context context;

    public UserAdapter(ArrayList<Users> user,Context context){
        this.user = user;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

       // context=parent.getContext();
        View view = li.inflate(R.layout.user_view, parent, false);

       // UserAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view,parent,false));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Users currentUser = user.get(position);

        holder.userID.setText((currentUser.getId().toString()));
        holder.login.setText(currentUser.getLogin());

        final String userPic = currentUser.getAvatar();
        Glide.with(context).load(userPic).into(holder.urlImage);

        holder.urlImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SingleUsernameActivity.class);
                i.putExtra("PicUrl",userPic);
                i.putExtra("Username",currentUser.getLogin());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView login;
        ImageView urlImage;
        TextView userID;

        public ViewHolder(View itemView) {
            super(itemView);

            login = (TextView) itemView.findViewById(R.id.userName);
            urlImage = (ImageView) itemView.findViewById(R.id.urlImage);
            userID = (TextView) itemView.findViewById(R.id.userID);
        }
    }

}
