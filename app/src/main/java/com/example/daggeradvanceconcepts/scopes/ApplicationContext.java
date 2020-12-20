package com.example.daggeradvanceconcepts.scopes;

import javax.inject.Qualifier;


@Qualifier
public @interface ApplicationContext {

//    Alternative to @Named annotation is @Qualifier annotation.
//    For creating ApplicationContext using @Qualifier, we need to create a separate
//    @interface and use it where ever necessary. Let’s create an @interface ApplicationContext first.

}
