package com.example.daggeradvanceconcepts.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.daggeradvanceconcepts.factory.ViewModelFactory;
import com.example.daggeradvanceconcepts.viewmodel.NewListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule  {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(NewListViewModel.class)
    protected abstract ViewModel movieListViewModel(NewListViewModel newListViewModel);

}
