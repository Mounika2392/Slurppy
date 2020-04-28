package com.learner.slurppy.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.learner.slurppy.R
import com.learner.slurppy.databinding.ActivityRecyclerViewBinding
import com.learner.slurppy.datamodels.AlbumResponse
import com.learner.slurppy.services.AlbumService
import com.learner.slurppy.util.RecyclerAdapter
import com.learner.slurppy.util.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_recycler_view.*


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecyclerViewBinding
    var albumResponse : List<AlbumResponse>? =null
    private  lateinit var recyclerAdapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
        callAlbumData()
        initRecyclerView()
    }

    private fun submitData() {
        albumResponse?.let { recyclerAdapter.setData(it) }
    }

    fun initRecyclerView() {
        recyclerviewholder.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerAdapter = RecyclerAdapter()
            adapter = recyclerAdapter
        }
    }

        fun callAlbumData() {
            Log.d("response", "Call made")

            val apiClient = RetrofitBuilder()
            val apiService = apiClient.getClient()!!.create(AlbumService::class.java)
            val albumServiceCall: Call<List<AlbumResponse>> = apiService.getImages()

            Log.d("response", albumServiceCall.toString())

            albumServiceCall.enqueue(object : Callback<List<AlbumResponse>> {

                override fun onResponse(call: Call<List<AlbumResponse>>, response: Response<List<AlbumResponse>>) {
                    if (response.code() == 200) {
                        Log.d("response", response.body()?.get(1)?.title)
                        albumResponse = response.body()!!
                        recyclerAdapter.setData(albumResponse!!)
                    }
                }

                override fun onFailure(call: Call<List<AlbumResponse>>, t: Throwable) {
                    Log.d("response", t.localizedMessage)

                }

            })
    }

    }
