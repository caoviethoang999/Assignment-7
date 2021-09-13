package com.example.hoangcv2_assiagnment.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.RecyclerViewMargin
import com.example.hoangcv2_assiagnment.RecyclerViewProductMargin
import com.example.hoangcv2_assiagnment.adapter.ItemAdapter
import com.example.hoangcv2_assiagnment.adapter.TopProductAdapter
import com.example.hoangcv2_assiagnment.model.ItemCategory
import com.example.hoangcv2_assiagnment.model.Product
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    lateinit var topProductAdapter: TopProductAdapter
    lateinit var itemAdapter: ItemAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(toolBarHome)
        val toggle = ActionBarDrawerToggle(
            activity, drawer_layout, toolBarHome,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        addDataTopProduct()
        addDataCategoryItem()
    }

//test
    fun addDataTopProduct() {
        recylerViewTopProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        topProductAdapter = TopProductAdapter()
        recylerViewTopProduct.addItemDecoration(
            RecyclerViewProductMargin(
                2,
                resources.getDimensionPixelSize(R.dimen.recyclerView_product_marginTop)
            )
        )
        val list: MutableList<Product>
        list = ArrayList()
        list.add(Product("Grapes", "$1.50", R.drawable.grapes, R.drawable.background_grapes))
        list.add(Product("Tomato", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        list.add(Product("Pumpkins", "$1.50", R.drawable.tomato, R.drawable.background_tomato))
        topProductAdapter.getAll(list)
        recylerViewTopProduct.adapter = topProductAdapter
    }

    fun addDataCategoryItem() {
        recylerViewItem.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        itemAdapter = ItemAdapter()
        recylerViewItem.addItemDecoration(
            RecyclerViewMargin(
                1,
                resources.getDimensionPixelSize(R.dimen.recyclerView_item_marginRight)
            )
        )
        val list: MutableList<ItemCategory>
        list = ArrayList()
        list.add(
            ItemCategory(
                "Vegetables",
                R.drawable.vegetables,
                R.drawable.background_vegetables
            )
        )
        list.add(ItemCategory("Drinks", R.drawable.drinks, R.drawable.background_drinks))
        list.add(ItemCategory("Fruits", R.drawable.fruits, R.drawable.background_fruits))
        itemAdapter.getAll(list)
        recylerViewItem.adapter = itemAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_shopping, menu)
    }
}