package com.learner.slurppy.util

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learner.slurppy.R
import com.learner.slurppy.datamodels.AlbumResponse
import kotlinx.android.synthetic.main.recycler_view_row_details.view.*
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

        fun bind(albumResponse: AlbumResponse){
            Log.d("response",albumResponse?.title)

            album.setText(albumResponse.albums)
            id.setText(albumResponse.id)
            title.setText(albumResponse.title)
//            image.setImageURI(albumResponse.url)
        }
    }

}