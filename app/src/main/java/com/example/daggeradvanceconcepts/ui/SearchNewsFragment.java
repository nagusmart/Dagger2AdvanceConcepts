package com.example.daggeradvanceconcepts.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daggeradvanceconcepts.R;
import com.example.daggeradvanceconcepts.factory.ViewModelFactory;
import com.example.daggeradvanceconcepts.model.News;
import com.example.daggeradvanceconcepts.viewmodel.NewListViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;


public class SearchNewsFragment extends BaseFragment {

    @Inject
    ViewModelFactory viewModelFactory;

    RecyclerView recyclerView;

    List<News> newsArrayList = new ArrayList<>();

    NewListViewModel newListViewModel;

    NewsAdapter newsAdapter;




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SearchNewsFragment() {
        // Required empty public constructor
    }


    public static SearchNewsFragment newInstance(String param1, String param2) {
        SearchNewsFragment fragment = new SearchNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search_news, container, false);

        recyclerView =view.findViewById(R.id.show_news);

        setAdapter();

        return view;
    }


    public void setAdapter(){
        newsAdapter=new NewsAdapter(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(newsAdapter);

        if(viewModelFactory!=null) {

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
    }
}
