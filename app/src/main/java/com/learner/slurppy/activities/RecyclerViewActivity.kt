package com.learner.slurppy.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.learner.slurppy.R
import com.learner.slurppy.databinding.ActivityRecyclerViewBinding
import com.learner.slurppy.datamodels.AlbumDataModel
import com.learner.slurppy.datamodels.AlbumResponse
import com.learner.slurppy.services.AlbumService
import com.learner.slurppy.util.RetrofitBuilder


import retrofit2.Call
import retrofit2.Response

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecyclerViewBinding
    private lateinit var albumResponse : AlbumResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_view)
        binding.testButton.setOnClickListener {
            callAlbumData()
        }
    }

        fun callAlbumData() {
            Log.d("response", "Call made")
            val apiClient = RetrofitBuilder()

            val apiService = apiClient.getClient()!!.create(AlbumService::class.java)
            val albumServiceCall: Call<AlbumResponse> = apiService.getImages(1)

            albumServiceCall.enqueue(object : retrofit2.Callback<AlbumResponse> {
                override fun onResponse(call: Call<AlbumResponse>, response: Response<AlbumResponse>) {
                    if (response.code() == 200) {
                        Log.d("response", response.toString())
                        albumResponse = response.body()!!
                        Log.d("response", albumResponse.title)
                    }
                }

                override fun onFailure(call: Call<AlbumResponse>, t: Throwable) {
                    Log.d("response", t.localizedMessage)

                }
            })
    }

    }
