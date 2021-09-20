package com.example.hoangcv2_assiagnment.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hoangcv2_assiagnment.OnItemClickListener
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.RecyclerViewProductMargin
import com.example.hoangcv2_assiagnment.Status
import com.example.hoangcv2_assiagnment.adapter.ProductAdapter
import com.example.hoangcv2_assiagnment.api.ProductService
import com.example.hoangcv2_assiagnment.viewmodel.ProductRepository
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModel
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModelFactory
import kotlinx.android.synthetic.main.fragment_product.*
import kotlinx.android.synthetic.main.fragment_product.recylerViewProduct

class ProductFragment : Fragment(),OnItemClickListener {
    lateinit var viewModel: ProductViewModel
    private val productService = ProductService.getInstance()
    lateinit var productAdapter: ProductAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(toolBarProduct)
        appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val bundle = this.arguments
        val title = bundle!!.getString("name")
        txtCategories.text=title
        if(title.equals("vegetables")) {
            addData()
        }
    }


    fun addData() {
        recylerViewProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        productAdapter = ProductAdapter(this)
        recylerViewProduct.addItemDecoration(
            RecyclerViewProductMargin(
                2,
                resources.getDimensionPixelSize(R.dimen.recyclerView_product_marginTop)
            )
        )
        viewModel.getProductByCategory(1)
        viewModel.productList.observe(viewLifecycleOwner, {
                productAdapter.getAll(it)
                recylerViewProduct.adapter = productAdapter
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this, ProductViewModelFactory(ProductRepository(productService))).get(ProductViewModel::class.java)
        return inflater.inflate(R.layout.fragment_product, container, false)
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

    override fun onItemClick(position: Int,status:Status) {
        if (status== Status.DETAIL) {
            val recylerFragment = DetailFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(null)?.replace(R.id.fragment_container, recylerFragment)?.commit()
        }
    }
}