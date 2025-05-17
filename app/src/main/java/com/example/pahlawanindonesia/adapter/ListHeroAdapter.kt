package com.example.pahlawanindonesia.adapter

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.customview.widget.ViewDragHelper.Callback
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawanindonesia.R
import com.example.pahlawanindonesia.model.Hero

class ListHeroAdapter (private val listhero: ArrayList<Hero>,
    private val onItemClick:(Hero) -> Unit): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>(){

        private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Hero)
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHeroAdapter.ListViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
            return ListViewHolder(view)
        }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,desc,photo) = listhero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = desc
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listhero[position])
        }
    }

    override fun getItemCount(): Int = listhero.size

    class ListViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.txt_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.txt_item_description)
    }
    }