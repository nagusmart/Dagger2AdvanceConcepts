package com.example.daggeradvanceconcepts.module;

import com.example.daggeradvanceconcepts.data.service.NewsApiServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NewsModule {

    @Provides
    @Singleton
    public NewsApiServices newsApiServices(Retrofit retrofit){
        return retrofit.create(NewsApiServices.class);
    }

    @Provides
    @Singleton
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory,OkHttpClient okHttpClient){


      /*  OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("x-rapidapi-key","d907e1b81emsha76b037e3a900d3p1d3acdjsne0ae42884ddf")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        }).build();*/

//        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//        OkHttpClient client = httpClient.build();

        return new Retrofit.Builder().baseUrl("https://bing-news-search1.p.rapidapi.com/").addConverterFactory(gsonConverterFactory).client(okHttpClient).build();
    }


    @Provides
    @Singleton
    public Gson gson(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

}
