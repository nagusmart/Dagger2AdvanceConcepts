package com.example.daggeradvanceconcepts.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface MainActivityScope {

//    @Scope annotation tells dagger to create single instance, even if <DaggerComponent>.build() is called many times. It will make the dependency work as singleton.

}

