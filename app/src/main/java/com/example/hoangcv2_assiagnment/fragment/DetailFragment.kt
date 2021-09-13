package com.example.hoangcv2_assiagnment.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.RecyclerViewMargin
import com.example.hoangcv2_assiagnment.adapter.RelatedItemAdapter
import com.example.hoangcv2_assiagnment.model.Product
import kotlinx.android.synthetic.main.fragment_detail.*
import java.util.*

class DetailFragment : Fragment() {
    lateinit var relatedItemAdapter: RelatedItemAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(toolBarDetail)
        appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        addData()
        addDataToImageSlider()
        btnAddCart.setOnClickListener {
            txtPriceItem.text=elegantNumber.getNumber()
        }
    }


    fun addDataToImageSlider(){
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.tomato))
        imageList.add(SlideModel(R.drawable.grapes))
        imageList.add(SlideModel(R.drawable.pumpkins))
        image_slider.setImageList(imageList)
    }
    fun addData() {
        recylerViewProduct.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        relatedItemAdapter = RelatedItemAdapter()
        recylerViewProduct.addItemDecoration(
            RecyclerViewMargin(
                1,
                resources.getDimensionPixelSize(R.dimen.recyclerView_item_marginRight)
            )
        )
        val list: MutableList<Product>
        list = ArrayList()
        list.add(Product("Tomato", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.pumpkins, R.drawable.background_pumpkin))
        list.add(Product("Tomato", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.pumpkins, R.drawable.background_pumpkin))
        list.add(Product("Tomato", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.pumpkins, R.drawable.background_pumpkin))
        list.add(Product("Tomato", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.pumpkins, R.drawable.background_pumpkin))
        list.add(Product("Tomato", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.pumpkins, R.drawable.background_pumpkin))
        list.add(Product("Tomato", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.pumpkins, R.drawable.background_pumpkin))
        relatedItemAdapter.getAll(list)
        recylerViewProduct.adapter = relatedItemAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_shopping, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}