package com.example.retrofitandroid;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    public PostsAdapter(List<posts> postsList) {
        this.postsList = postsList;
    }

    private  List<posts> postsList;



    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
    holder.tvtitle.setText(postsList.get(position).getTitle());
    holder.tvbody.setText(postsList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvtitle , tvbody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvbody = itemView.findViewById(R.id.tvbody);
        }
    }
}
