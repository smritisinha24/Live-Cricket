package com.example.livecricketscore.Model


import com.google.gson.annotations.SerializedName

data class CricketData(
    val apikey: String,
    val `data`: List<Data>,
    val info: Info,
    val status: String
    )