package com.learner.slurppy.util

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.learner.slurppy.R
import com.learner.slurppy.datamodels.AlbumResponse
import kotlinx.android.synthetic.main.recycler_view_row_details.view.*
import java.time.Instant
import java.time.format.DateTimeFormatter
import androidx.recyclerview.widget.RecyclerView.ViewHolder as ViewHolder

class RecyclerAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var responseItems: List<AlbumResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

     return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row_details, parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is MyViewHolder ->
                holder.bind(responseItems!!.get(position))
        }
    }

    override fun getItemCount(): Int {
        Log.d("response", responseItems.size.toString())
        return responseItems!!.size
    }

    fun setData(albumResponse: List<AlbumResponse>){
        responseItems = albumResponse
        Log.d("response",responseItems.size.toString())
        notifyDataSetChanged()
    }

    // Setting frontend elements to variables
    class MyViewHolder constructor(itemView : View) : ViewHolder(itemView)
    {
//       variables =  ui elements
        val album = itemView.tv_albumcount
        val id = itemView.tv_id
        val title = itemView.tv_Title
        val image = itemView.image

        fun bind(albumResponse: AlbumResponse) {
            Log.d("response", albumResponse?.title)

            album.setText(albumResponse.albumId)
            id.setText(albumResponse.id)
            title.setText(albumResponse.title)

            val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(albumResponse.url)
                    .override(410,260)
                    .into(image)
Log.d("response", albumResponse.url)
        }
    }

}