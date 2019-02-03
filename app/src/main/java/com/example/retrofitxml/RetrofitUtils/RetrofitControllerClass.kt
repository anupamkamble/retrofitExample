package com.example.retrofitxml.RetrofitUtils

import android.util.Log
import com.example.retrofitxml.JsonModels.UserData
import com.example.retrofitxml.JsonModels.UserModel
import com.example.retrofitxml.XMLModels.Article
import com.example.retrofitxml.XMLModels.RssFeed
import com.google.gson.Gson
import kotlinx.android.synthetic.*
import retrofit2.Call
import retrofit2.Callback;
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

public class RetrofitControllerClass (): Callback<RssFeed>{

    var BASE_URL: String = "https://vogella.com/";
    var USER_URL: String = "https://reqres.in/";

    public fun loadURL(){
        val retrofit = Retrofit.Builder().
            baseUrl(BASE_URL).
            addConverterFactory(SimpleXmlConverterFactory.create()).build()

        val vogellaAPI = retrofit.create(PrimaryAPI::class.java)

        val call = vogellaAPI.loadRssFeed()
        call.enqueue(this)
    }

    public  fun loadUserDataPerPage(){

        val retrofit = Retrofit.Builder().
            baseUrl(USER_URL).
            addConverterFactory(GsonConverterFactory.create()).build()

        val vogellaAPI = retrofit.create(PrimaryAPI::class.java)

        val call = vogellaAPI.loadUserDateWithPage("2")

        call.enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
                //


            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                //

                if(response!!.isSuccessful){
                    val rssFeed = response.body()
                    Log.e("APi with channel title", rssFeed!!.page.toString())

                    rssFeed.data!!.forEach {
                            user: UserData -> Log.e("avatar",user.avatar )
                    }
                }else{
                    Log.e("failure", response?.errorBody().toString())
                }
            }
        })


    }




    override fun onFailure(call: Call<RssFeed>, t: Throwable) {
        t.stackTrace
    }

    override fun onResponse(call: Call<RssFeed>, response: Response<RssFeed>) {

        if(response.isSuccessful){
            val rssFeed = response.body()
            Log.e("APi with channel title", rssFeed!!.channelTitle)

            rssFeed.articleList!!.forEach {
                article: Article -> Log.e("description",article.description )
                Log.e("articletitle",article.title)
            }
        }else{
            Log.e("failure", response?.errorBody().toString())
        }

    }

}

