package com.mzulsept.zulrestapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class KategoriAdapter ( val dataKategori: List<DataKategori?>?, param: (Any) -> Unit) : RecyclerView.Adapter<KategoriAdapter.MyViewHolder>(){
    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val namakategori = view.findViewById<TextView>(R.id.namakategori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kategori,parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataKategori != null){
            return dataKategori.size
        }
        return 0
    }

    override fun onBindViewHolder(holder:KategoriAdapter.MyViewHolder, position: Int) {
        val currentItem = dataKategori?.get(position)

        holder.namakategori.text = currentItem?.namaKategori

        holder.itemView.setOnClickListener{
            val namaKategori = dataKategori?.get(position)?.namaKategori
            Toast.makeText(holder.itemView.context, "${namaKategori}", Toast.LENGTH_SHORT).show()
        }

    }
}