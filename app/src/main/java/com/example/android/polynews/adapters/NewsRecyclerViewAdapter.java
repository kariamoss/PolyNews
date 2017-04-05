package com.example.android.polynews.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.polynews.models.ArticleModel;

import java.util.List;

/**
 * Created by Jehan on 05/04/2017.
 */

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsCache> {

    List<ArticleModel> data;

    public NewsRecyclerViewAdapter(List<ArticleModel> objects){
        this.data = objects;
    }

    @Override
    public NewsCache onCreateViewHolder(ViewGroup parent, int viewType) {
        //TODO Create the newsCache viewHolder
        return null;
    }

    @Override
    public void onBindViewHolder(NewsCache holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NewsCache extends RecyclerView.ViewHolder{
        public NewsCache(View itemView){
            super(itemView);
            //TODO Do all the find view by id
        }

        void bind(ArticleModel articleModel){
            //TODO set the data in the view
        }
    }
}