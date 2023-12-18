package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BASE_URL = "https://v2.jokeapi.dev/joke/Programming";

    private static final JokeApiService jokeApiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeApiService.class);

    public static JokeApiService getJokeApiService() {
        return jokeApiService;
    }
}
