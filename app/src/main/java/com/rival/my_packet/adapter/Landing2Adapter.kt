package com.rival.my_packet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rival.my_packet.R
import com.rival.my_packet.model.Result

class Landing2Adapter(var landingItem: Result?) : RecyclerView.Adapter<Landing2Adapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvNamaSelesai = itemView.findViewById<TextView>(R.id.nama)
        val tvTanggalSelesai = itemView.findViewById<TextView>(R.id.tanggal)
        val tvStatusSelesai = itemView.findViewById<TextView>(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_landing, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.tvNamaSelesai.text = landingItem?.paketselesai?.get(position)?.nama_penerima
        holder.tvTanggalSelesai.text = landingItem?.paketselesai?.get(position)?.tanggal_input
        holder.tvStatusSelesai.text = landingItem?.paketselesai?.get(position)?.status


    }

    override fun getItemCount(): Int {
        return landingItem?.paketselesai?.size ?: 0

    }

}