package com.example.hoangcv2_assiagnment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hoangcv2_assiagnment.OnItemClickListener
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.fragment.ProductFragment
import com.example.hoangcv2_assiagnment.model.ItemCategory
import java.util.*


class ItemAdapter(var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    var list: MutableList<ItemCategory>
    fun getAll(list: MutableList<ItemCategory>?) {
        this.list = list!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_custom_view, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemCategory: ItemCategory = list[position]
        holder.txtTitle1.text = itemCategory.title
        holder.imgViewItem.setImageResource(itemCategory.image)
        holder.imgViewItem.setBackgroundResource(itemCategory.imageBackground)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position,1)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle1: TextView
        var imgViewItem: ImageView

        init {
            txtTitle1 = itemView.findViewById(R.id.textViewItem1)
            imgViewItem = itemView.findViewById(R.id.imageViewItem1)
        }
    }

    init {
        list = ArrayList<ItemCategory>()
    }
}