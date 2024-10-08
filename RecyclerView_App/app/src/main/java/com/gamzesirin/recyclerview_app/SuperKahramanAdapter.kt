package com.gamzesirin.recyclerview_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gamzesirin.recyclerview_app.databinding.RecyclerRowBinding

class SuperKahramanAdapter(val SuperKahramanListesi: ArrayList<SuperKahraman>) : RecyclerView.Adapter<SuperKahramanAdapter.SuperKahramanViewHolder>() {

    class SuperKahramanViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuperKahramanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SuperKahramanViewHolder, position: Int) {
        holder.binding.textViewRecyclerView.text=SuperKahramanListesi[position].isim

        holder.itemView.setOnClickListener{
            val intent =Intent (holder.itemView.context, TanitimAktivitesi::class.java)
            intent.putExtra("seçilenKahraman", SuperKahramanListesi[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return SuperKahramanListesi.size
    }
}