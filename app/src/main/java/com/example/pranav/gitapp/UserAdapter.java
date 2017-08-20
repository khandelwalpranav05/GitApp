package com.example.pranav.gitapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        View view = li.inflate(R.layout.user_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Users currentUser = user.get(position);

        holder.userID.setText(currentUser.getId());
        holder.login.setText(currentUser.getLogin());

        String userPic = currentUser.getAvatar();
        Picasso.with(context).load(userPic).fit().into(holder.urlImage);

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
