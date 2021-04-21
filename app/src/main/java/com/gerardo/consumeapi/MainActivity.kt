package com.gerardo.consumeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val api:ApiService = getRetrofit().create(ApiService::class.java)

        api.getAllCharacters().enqueue(object:Callback<CharactersResponse>{
            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<CharactersResponse>,response: Response<CharactersResponse>) {
                Enlazar(response.body()!!.results)


            }
        })
    }

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun Enlazar(datos:List<Character>){
        val myRecycler:RecyclerView = findViewById(R.id.MyRecycler)
        val myAdapter:MyAdapter= MyAdapter(datos)
        myRecycler.apply {
            adapter = myAdapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }

    }
}