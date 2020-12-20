package com.example.daggeradvanceconcepts.module;

import android.content.Context;

import com.example.daggeradvanceconcepts.scopes.ApplicationContext;
import com.example.daggeradvanceconcepts.scopes.NewsApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context){
        this.context=context;
    }

    //@Named("application_context")
    @ApplicationContext
    @NewsApplicationScope
    @Provides
    public Context context(){
        return context.getApplicationContext();
    }
}
