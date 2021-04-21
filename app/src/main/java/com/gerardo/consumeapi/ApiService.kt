package com.gerardo.consumeapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET("character")
    fun getAllCharacters(): Call<CharactersResponse>
}