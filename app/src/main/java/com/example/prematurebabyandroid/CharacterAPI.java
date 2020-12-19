package com.example.prematurebabyandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterAPI {

    @GET("/api/character/{id}")
    Call<Character> getCharacterByID(@Path("id") String id);
//    Call<Character> loadCharacter(@Query("q") String status);
}
