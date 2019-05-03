package com.example.retrofitkotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class Controller{
    public fun getApiArguments():AnekdotAPI?{
        //создали Retrofit.Builder и провели  настройку
        val retrofit = Retrofit.Builder()
            .baseUrl("http://umorili.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //запихнули retrofit в class AnekdotAPI
       return retrofit.create( AnekdotAPI::class.java)
    }


}