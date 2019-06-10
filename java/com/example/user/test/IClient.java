package com.example.user.test;

import com.example.user.test.models.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 10/04/2018.
 */

public interface IClient {

    @GET("client/all")
    Call<List<Client>> all();

    @GET("client/getById")
    Call<Client> getById(@Query("mail") String mail, @Query("mdp") String mdp) ;

    @GET("client/add")
    Call<String> add(@Query("surname") String surname, @Query("namee") String namee, @Query("date_of_birth") String date_of_birth,@Query("mail") String mail, @Query("mdp") String mdp, @Query("phone") int phone ) ;

    @GET("client/remove")
    Call<Client> remove(@Query("idt") int idt);

    @GET("client/update")
    Call<Client> update(@Query("idt") int idt, @Query("mdp") String mdp);
}

