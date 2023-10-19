package com.mzulsept.zulrestapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mzulsept.zulrestapi.api.ApiConfig

class PostAdapter (
    val dataPost: List<DataPosts?>?, param:(Any)-> Unit ): RecyclerView.Adapter<PostAdapter.MyViewHolder>(){
    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val imgPost = view.findViewById<ImageView>(R.id.item_image_post)
        val titlePost = view.findViewById<TextView>(R.id.title)
        val contentPost = view.findViewById<TextView>(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       if (dataPost != null){
           return dataPost.size
       }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataPost?.get(position)

        holder.titlePost.text = currentItem?.title
        holder.contentPost.text = currentItem?.content

        Glide.with(holder.itemView.context)
            .load(currentItem?.image)
            .into(holder.imgPost)

        holder.itemView.setOnClickListener{
            val title = dataPost?.get(position)?.title
            Toast.makeText(holder.itemView.context, "${title}", Toast.LENGTH_SHORT).show()
        }

    }

}