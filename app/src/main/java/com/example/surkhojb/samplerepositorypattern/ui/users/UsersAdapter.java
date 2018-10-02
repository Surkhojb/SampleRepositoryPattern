package com.example.surkhojb.samplerepositorypattern.ui.users;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.surkhojb.samplerepositorypattern.R;
import com.example.surkhojb.samplerepositorypattern.domain.Post;
import com.example.surkhojb.samplerepositorypattern.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 2/10/18.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private List<User> users;
    private UsersAdapterClick clickUserListener;

    public UsersAdapter(){
        users = new ArrayList<>();
    }

    public void setOnUserClickListener(UsersAdapterClick listener){
        this.clickUserListener = listener;
    }

    public void setData(List<User> items){
        if(items != null ){
            users.clear();
            users.addAll(items);

            notifyDataSetChanged();
        }

    }

    public User getUserAtPosition(int position){
        return users.get(position);
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users,parent,false);
        return new UsersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class UsersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView itemName;
        private TextView itemNick;
        private TextView itemEmail;
        private TextView itemShared;
        private TextView itemViews;

        public UsersViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_user_name);
            itemNick = itemView.findViewById(R.id.item_user_nick);
            itemEmail = itemView.findViewById(R.id.item_user_email);
            itemViews = itemView.findViewById(R.id.item_user_views);
            itemShared = itemView.findViewById(R.id.item_user_shared);
            itemView.setOnClickListener(this);
        }

        public void bind(User item){
            int random = (int) (Math.random() * 500) + 1;

            itemName.setText(itemView.getContext().getString(R.string.user_name) + item.getUserName());
            itemNick.setText(itemView.getContext().getString(R.string.user_nickname) + item.getUserNickname());
            itemEmail.setText(itemView.getContext().getString(R.string.user_email) + item.getUserEmail());
            itemViews.setText(String.valueOf(random));
            itemShared.setText(String.valueOf(random));
        }

        @Override
        public void onClick(View view) {
            clickUserListener.onUserClicked(getAdapterPosition());
        }
    }
}
