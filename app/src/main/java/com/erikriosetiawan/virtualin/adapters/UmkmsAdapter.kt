package com.erikriosetiawan.virtualin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.erikriosetiawan.virtualin.R
import com.erikriosetiawan.virtualin.models.Umkm

class UmkmsAdapter(var context: Context? = null, var umkms: MutableList<Umkm>? = null) :
    RecyclerView.Adapter<UmkmsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.umkm_item, parent, false))

    override fun getItemCount(): Int = umkms?.size ?: -1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        umkms?.let { it[position] }?.let {
            holder.bindItem(it) {
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgIcon: ImageView = view.findViewById(R.id.img_icon)
        private val tvUmkmName: TextView = view.findViewById(R.id.tv_umkm_name)
        private val tvUmkmFounder: TextView = view.findViewById(R.id.tv_umkm_founder)
        private val tvUmkmRating: TextView = view.findViewById(R.id.tv_umkm_rating)

        fun bindItem(umkm: Umkm, listener: (Umkm) -> Unit) {
            umkm.icon?.let { imgIcon.setImageResource(it) }
            umkm.name?.let { tvUmkmName.text = it }
            umkm.founder?.let {
                tvUmkmFounder.text = itemView.resources.getString(R.string.founder, it)
            }
            umkm.rating?.let { tvUmkmRating.text = it.toString() }

            itemView.setOnClickListener { listener(umkm) }
        }
    }
}