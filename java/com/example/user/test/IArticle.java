package com.example.user.test;

import com.example.user.test.models.article;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 04/06/2019.
 */

public interface IArticle {
    @GET("article/all")
    Call<List<article>> all();

    @GET("article/getByRef")
    Call<article> getByRef(@Query("ref") String ref) ;

    @GET("article/getByPrice")
    Call<article> getByPrice(@Query("price") float price) ;

    @GET("article/add")
    Call<String> add(@Query("ref") String ref, @Query("quantity") int quantity, @Query("type_dress") String type_dress,@Query("price") float price, @Query("descrp") String descrp, @Query("imageURL") String imageURL ) ;

    @GET("article/remove")
    Call<article> remove(@Query("ref") String ref);

    @GET("article/update")
    Call<article> update(@Query("price") float price, @Query("quantity") int quantity, @Query("imageURL") String imageURL);

}
