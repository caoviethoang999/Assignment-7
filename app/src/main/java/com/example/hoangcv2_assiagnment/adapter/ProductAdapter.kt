package com.example.hoangcv2_assiagnment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.fragment.DetailFragment
import com.example.hoangcv2_assiagnment.model.Product
import java.util.*


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ItemViewHolder>() {
    var list: MutableList<Product>
    fun getAll(list: MutableList<Product>?) {
        this.list = list!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.product_custom_view, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val product: Product = list[position]
        holder.txtTitle1.text = product.title
        holder.txtPrice.text = product.price
        holder.imgViewItem.setImageResource(product.image)
        holder.backgroundItem.setBackgroundResource(product.imageBackgournd)
        holder.itemView.setOnClickListener {
            val activity = it.context as AppCompatActivity
            val recylerFragment = DetailFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(null).replace(R.id.fragment_container, recylerFragment).commit()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle1: TextView
        var txtPrice: TextView
        var imgViewItem: ImageView
        var backgroundItem: ConstraintLayout

        init {
            txtTitle1 = itemView.findViewById(R.id.txtTitleItem)
            txtPrice = itemView.findViewById(R.id.txtPriceItem)
            imgViewItem = itemView.findViewById(R.id.imageViewItem)
            backgroundItem = itemView.findViewById(R.id.backgroundItem)
        }
    }

    init {
        list = ArrayList<Product>()
    }
}