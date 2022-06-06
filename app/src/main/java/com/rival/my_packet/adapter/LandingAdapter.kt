package com.rival.my_packet.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rival.my_packet.DetailActivity
import com.rival.my_packet.R
import com.rival.my_packet.model.PaketItem
import com.rival.my_packet.model.PaketselesaiItem
import com.rival.my_packet.model.Result

class LandingAdapter(var landingItem: Result?) :
    RecyclerView.Adapter<LandingAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvNama = itemView.findViewById<TextView>(R.id.nama)
        val tvTanggal = itemView.findViewById<TextView>(R.id.tanggal)
        val tvStatus = itemView.findViewById<TextView>(R.id.status)

//        val tvNamaSelesai = itemView.findViewById<TextView>(R.id.nama)
//        val tvTanggalSelesai = itemView.findViewById<TextView>(R.id.tanggal)
//        val tvStatusSelesai = itemView.findViewById<TextView>(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_landing, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNama.text = landingItem?.paket?.get(position)?.nama_penerima
        holder.tvTanggal.text = landingItem?.paket?.get(position)?.tanggal_input
        holder.tvStatus.text = landingItem?.paket?.get(position)?.status

        if (landingItem?.paket?.get(position)?.status == "satpam") {
            holder.tvStatus.setTextColor(holder.itemView.context.resources.getColor(R.color.purple_700))
        } else {
            holder.tvStatus.setTextColor(holder.itemView.context.resources.getColor(R.color.teal_700))
        }

        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("Data", landingItem?.paket?.get(position))
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return landingItem?.paket?.size ?: 0
    }

}

