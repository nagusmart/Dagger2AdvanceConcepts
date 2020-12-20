package com.example.daggeradvanceconcepts.module;

import com.example.daggeradvanceconcepts.ui.MainActivity;
import com.example.daggeradvanceconcepts.ui.SearchNewsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract SearchNewsFragment contributesSearchNewsFragment();

}
