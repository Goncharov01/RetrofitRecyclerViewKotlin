package com.example.retrofitkotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//http://umorili.herokuapp.com/api/get?name=new%20anekdot&num=1
//2)Создать интерфейс, определяющий возможные HTTP Операции (API)
interface AnekdotAPI {
    @GET("/api/get")
fun getAnekdots(@Query("name")string: String,@Query("num") int: Int): Call<List<Anekdot>>
}