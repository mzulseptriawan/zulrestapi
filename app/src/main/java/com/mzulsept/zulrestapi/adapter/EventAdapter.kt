package com.mzulsept.zulrestapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EventAdapter ( val dataEvent: List<DataEvent?>?, param: (Any) -> Unit) : RecyclerView.Adapter<EventAdapter.MyViewHolder>(){
    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val namaEvent = view.findViewById<TextView>(R.id.namaevent)
        val tempatEvent = view.findViewById<TextView>(R.id.tempatevent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event,parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataEvent != null){
            return dataEvent.size
        }
        return 0
    }

    override fun onBindViewHolder(holder:EventAdapter.MyViewHolder, position: Int) {
        val currentItem = dataEvent?.get(position)

        holder.namaEvent.text = currentItem?.namaevent
        holder.tempatEvent.text = currentItem?.tempat

        holder.itemView.setOnClickListener{
            val namaEvent = dataEvent?.get(position)?.namaevent
            Toast.makeText(holder.itemView.context, "${namaEvent}", Toast.LENGTH_SHORT).show()
        }

}
}