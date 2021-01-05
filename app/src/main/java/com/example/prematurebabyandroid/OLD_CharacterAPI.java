package com.example.prematurebabyandroid;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OLD_CharacterAPI {

    @GET("/api/character/{id}")
    Call<OLD_Character> getCharacterByID(@Path("id") String id);
//    Call<Character> loadCharacter(@Query("q") String status);

    @GET("/patients")
    Call<OLD_Character> test(@Query("q") String status);
}
