package com.example.prematurebabyandroid;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CharacterController implements Callback<Character> {

    static final String BASE_URL = "https://rickandmortyapi.com/";

    public void start(String id){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CharacterAPI characterAPI = retrofit.create(CharacterAPI.class);

//        Call<Character> call = characterAPI.loadCharacter("status:open");
        Call<Character> call = characterAPI.getCharacterByID(id);
        call.enqueue(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<Character> call, Response<Character> response) {
        if(response.isSuccessful()) {
            Character character = response.body();
            System.out.println("SUCCESS");
            System.out.println(character.getName());

//            character.forEach(character -> System.out.println(character.name));
        }
        else {
            System.out.println(response.errorBody());
            System.out.println("RESPONSE NOT SUCCESSFUL");
        }
    }

    @Override
    public void onFailure(Call<Character> call, Throwable t) {
        t.printStackTrace();
        System.out.println("RESPONSE FAIL");
    }
}
