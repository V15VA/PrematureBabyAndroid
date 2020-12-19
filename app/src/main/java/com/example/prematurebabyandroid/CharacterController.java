package com.example.prematurebabyandroid;


import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CharacterController {

    static final String BASE_URL = "https://rickandmortyapi.com/";

    public void Start(String id, @Nullable final CharacterCallback callback){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CharacterAPI characterAPI = retrofit.create(CharacterAPI.class);

        Call<Character> call = characterAPI.getCharacterByID(id);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                if(response.isSuccessful()) {

            Character character = response.body();
//                    character = response.body();
                    System.out.println("SUCCESS");
//                    System.out.println(character.getName());
                    returnCharacter(character);
                    if (callback != null) {
                        callback.onSuccess(character);
                    }
                    else{
                        System.out.println("In else");
                    }

                }
                else {
                    System.out.println(response.errorBody());
                    System.out.println("RESPONSE FAIL");
                }
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                t.printStackTrace();
                System.out.println("CONNECTION FAIL");
            }
        });
        // Use a switch with a second input parameter on start() to choose GET function
        // Or just get all data when the patient ID is selected and choose what to display on the
        // Android side
    }

    public Character returnCharacter(Character character2return) {
        return character2return;
    }


}
