package com.example.retrofitkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val anekdots = ArrayList<Anekdot>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv= findViewById<RecyclerView>(R.id.posts_recycle_view)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adapter=AnekdotAdapter(anekdots)
        rv.adapter = adapter


        Controller().getApiArguments()!!.getAnekdots("new anekdot", 10)
            .enqueue(object:Callback<List<Anekdot>>{
            override fun onFailure(call: Call<List<Anekdot>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<List<Anekdot>>?, response: Response<List<Anekdot>>?) {
                anekdots.addAll(response!!.body())
                adapter.setAnekdotList(anekdots)
                println(response.body())

            }
        })
    }
    }


