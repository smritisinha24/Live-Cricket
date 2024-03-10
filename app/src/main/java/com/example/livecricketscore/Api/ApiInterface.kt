package com.example.livecricketscore.Api

import com.example.livecricketscore.Model.CricketData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("currentMatches")
    fun getLiveScore(@Query("apikey") apikey : String) : Call<CricketData>

}