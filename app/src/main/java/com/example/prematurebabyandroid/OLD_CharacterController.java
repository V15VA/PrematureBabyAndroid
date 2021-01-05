package com.example.prematurebabyandroid;


import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class OLD_CharacterController {

    static final String BASE_URL = "https://rickandmortyapi.com/";

    public void Start(String id, @Nullable final OLD_CharacterCallback callback){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OLD_CharacterAPI OLDCharacterAPI = retrofit.create(OLD_CharacterAPI.class);

        Call<OLD_Character> call = OLDCharacterAPI.getCharacterByID(id);
        call.enqueue(new Callback<OLD_Character>() {
            @Override
            public void onResponse(Call<OLD_Character> call, Response<OLD_Character> response) {
                if(response.isSuccessful()) {

            OLD_Character OLDCharacter = response.body();
//                    character = response.body();
                    System.out.println("SUCCESS");
                    System.out.println(response.body());
//                    System.out.println(character.getName());
                    returnCharacter(OLDCharacter);
                    if (callback != null) {
                        callback.onSuccess(OLDCharacter);
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
            public void onFailure(Call<OLD_Character> call, Throwable t) {
                t.printStackTrace();
                System.out.println("CONNECTION FAIL");
            }
        });
        // Use a switch with a second input parameter on start() to choose GET function
        // Or just get all data when the patient ID is selected and choose what to display on the
        // Android side
    }

    public OLD_Character returnCharacter(OLD_Character OLDCharacter2Return) {
        return OLDCharacter2Return;
    }


}
