package com.example.daggeradvanceconcepts.component;

import android.app.Application;

import com.example.daggeradvanceconcepts.application.AppController;
import com.example.daggeradvanceconcepts.module.ActivityModule;
import com.example.daggeradvanceconcepts.module.FragmentModule;
import com.example.daggeradvanceconcepts.module.NewsModule;
import com.example.daggeradvanceconcepts.module.OkHttpClientModule;
import com.example.daggeradvanceconcepts.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules ={AndroidSupportInjectionModule.class, ActivityModule.class, FragmentModule.class, NewsModule.class,OkHttpClientModule.class,ViewModelModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

//        @BindsInstance
//        Builder apiModule(ApiModule apiModule);
//
//        @BindsInstance
//        Builder dbModule(DbModule dbModule);

        AppComponent build();
    }

    void inject(AppController appController);

}
