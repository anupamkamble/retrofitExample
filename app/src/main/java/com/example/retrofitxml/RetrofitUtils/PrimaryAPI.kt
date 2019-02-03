package com.example.retrofitxml.RetrofitUtils

import com.example.retrofitxml.JsonModels.UserModel
import com.example.retrofitxml.XMLModels.RssFeed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PrimaryAPI {

    @GET("article.rss")
    fun loadRssFeed() : Call<RssFeed>


    @GET("/api/users?")
    fun loadUserDateWithPage(@Query("page") page: String): Call<UserModel>


}