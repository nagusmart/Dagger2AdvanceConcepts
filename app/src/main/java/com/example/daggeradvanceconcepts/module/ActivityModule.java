package com.example.daggeradvanceconcepts.module;

import com.example.daggeradvanceconcepts.ui.MainActivity;
import com.example.daggeradvanceconcepts.ui.SecondaryActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector(modules =FragmentModule.class)
    abstract SecondaryActivity contributesSecondaryActivity();

}
