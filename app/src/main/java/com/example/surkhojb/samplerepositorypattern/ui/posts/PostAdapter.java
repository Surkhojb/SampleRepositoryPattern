package com.example.surkhojb.samplerepositorypattern.ui.posts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.surkhojb.samplerepositorypattern.R;
import com.example.surkhojb.samplerepositorypattern.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 26/9/18.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts;

    public PostAdapter(){
        posts = new ArrayList<>();
    }

    public void setData(List<Post> items){
        if(items != null ){
            posts.clear();
            posts.addAll(items);

            notifyDataSetChanged();
        }

    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posts,parent,false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        holder.bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private TextView itemBody;
        private TextView itemViews;
        private TextView itemShared;

        public PostViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.tv_item_title);
            itemBody = itemView.findViewById(R.id.tv_item_body);
            itemViews = itemView.findViewById(R.id.tv_item_post_views);
            itemShared = itemView.findViewById(R.id.tv_item_post_shared);
        }

        public void bind(Post item){
            int random = (int) (Math.random() * 500) + 1;

            itemTitle.setText(item.getPostTitle());
            itemBody.setText(item.getPostBody());
            itemViews.setText(String.valueOf(random));
            itemShared.setText(String.valueOf(random));
        }
    }
}
