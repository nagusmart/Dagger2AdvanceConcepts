package com.example.daggeradvanceconcepts.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.daggeradvanceconcepts.R;
import com.example.daggeradvanceconcepts.factory.ViewModelFactory;
import com.example.daggeradvanceconcepts.model.News;
import com.example.daggeradvanceconcepts.viewmodel.NewListViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {


    RecyclerView recyclerView;

    List<News> newsArrayList = new ArrayList<>();

    NewListViewModel newListViewModel;

    NewsAdapter newsAdapter;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Inject
    ViewModelFactory viewModelFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.show_news);

        ImageView imageView=findViewById(R.id.search_icon);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondaryActivity.class);
                startActivity(intent);

            }
        });


        setAdapter();
    }

    public void setAdapter(){
        newsAdapter=new NewsAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(newsAdapter);

        newListViewModel = ViewModelProviders.of(this, viewModelFactory).get(NewListViewModel.class);



        newListViewModel.getNewsList().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> newsList) {

                if (newsList.size() > 0) {
                    newsArrayList.clear();
                    newsArrayList.addAll(newsList);
                    newsAdapter.setList(newsArrayList);
                    newsAdapter.notifyDataSetChanged();
                }
            }
        });
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
