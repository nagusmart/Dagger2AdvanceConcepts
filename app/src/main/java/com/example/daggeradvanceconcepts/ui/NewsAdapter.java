package com.example.daggeradvanceconcepts.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.daggeradvanceconcepts.R;
import com.example.daggeradvanceconcepts.helper.GlideApp;
import com.example.daggeradvanceconcepts.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> newsList = new ArrayList<>();
    private Context context;

    public NewsAdapter(Context context) {
        this.context=context;
    }
    public void setList(List<News> newsList){
        this.newsList=newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        News news = newsList.get(position);

         holder.discription.setText(news.getDescription());

         if(news.getImages().getThumbnailModle().getContentUrl()!=null) {
             holder.imageKey.setText(news.getImages().getThumbnailModle().getContentUrl());

             GlideApp.with(context)
                     .load(news.getImages().getThumbnailModle().getContentUrl())
                     .centerCrop()
                     .into(holder.showImage);
         }

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView showImage;
        TextView discription;
        TextView imageKey;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            showImage = itemView.findViewById(R.id.show_image);
            discription = itemView.findViewById(R.id.discription);
            imageKey = itemView.findViewById(R.id.image_key);

        }

    }

}
