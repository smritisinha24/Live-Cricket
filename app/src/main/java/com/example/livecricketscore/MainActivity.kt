package com.example.livecricketscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.livecricketscore.Adapter.CricketAdapter
import com.example.livecricketscore.Api.RetrofitInstance
import com.example.livecricketscore.Model.CricketData
import com.example.livecricketscore.Model.Data
import com.example.livecricketscore.databinding.ActivityMainBinding
import com.example.livecricketscore.databinding.ItemLayoutBinding
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: CricketAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        RetrofitInstance.api.getLiveScore("7b062c16-232b-4128-b97b-ed255d4ab1c8").enqueue(object : Callback<CricketData?> {
            override fun onResponse(call: Call<CricketData?>, response: Response<CricketData?>) {

                if(response.isSuccessful){

                    adapter = CricketAdapter(response.body()!!.data as ArrayList<Data>)
                    binding.recyclerView.adapter = adapter

                }else{
                    Toast.makeText(this@MainActivity,response.message(),Toast.LENGTH_LONG).show()

                }
            }

            override fun onFailure(call: Call<CricketData?>, t: Throwable) {

                Toast.makeText(this@MainActivity,t.localizedMessage,Toast.LENGTH_LONG).show()

            }
        })
    }
}