package com.example.surkhojb.samplerepositorypattern.ui.comments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.surkhojb.samplerepositorypattern.R;
import com.example.surkhojb.samplerepositorypattern.domain.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 4/10/18.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {
    private List<Comment> comments;

    public CommentsAdapter(){
        comments = new ArrayList<>();
    }

    public void setData(List<Comment> items){
        if(items != null ){
            comments.clear();
            comments.addAll(items);

            notifyDataSetChanged();
        }

    }

    @Override
    public CommentsAdapter.CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,parent,false);
        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.CommentsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentsViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private TextView itemBody;
        private TextView itemViews;
        private TextView itemShared;

        public CommentsViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.item_comment_name);
            itemBody = itemView.findViewById(R.id.item_comment_body);
            itemViews = itemView.findViewById(R.id.item_comment_views);
            itemShared = itemView.findViewById(R.id.item_comment_shared);
        }

        public void bind(Comment item){
            int random = (int) (Math.random() * 500) + 1;

            itemTitle.setText(item.getCommentName());
            itemBody.setText(item.getCommentBody());
            itemViews.setText(String.valueOf(random));
            itemShared.setText(String.valueOf(random));
        }
    }
}
