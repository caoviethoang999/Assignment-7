package com.example.hoangcv2_assiagnment.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.hoangcv2_assiagnment.model.Category
import com.example.hoangcv2_assiagnment.model.Product

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductViewModel constructor(private val mainRepository: ProductRepository) : ViewModel() {


    val productList=MutableLiveData<MutableList<Product>>()
    val categoryList = MutableLiveData<MutableList<Category>>()
    fun getProduct() {
        mainRepository.getAllProduct().enqueue(object: Callback<MutableList<Product>> {
            override fun onResponse(call: Call<MutableList<Product>>, response: Response<MutableList<Product>>) {
                productList.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Product>>, t: Throwable) {
            }
        })
    }
    fun getCategory(){
        mainRepository.getCategory().enqueue(object: Callback<MutableList<Category>> {
            override fun onResponse(call: Call<MutableList<Category>>, response: Response<MutableList<Category>>) {
                categoryList.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Category>>, t: Throwable) {
            }
        })
    }
    fun getProductByCategory(categoryId: Int){
        mainRepository.getProductByCategory(categoryId).enqueue(object : Callback<MutableList<Product>> {
            override fun onResponse(
                call: Call<MutableList<Product>>,
                response: Response<MutableList<Product>>
            ) {
                productList.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Product>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    fun checkCategory(categoryId: Int){
        mainRepository.checkCategory(categoryId).enqueue(object: Callback<MutableList<Category>> {
            override fun onResponse(call: Call<MutableList<Category>>, response: Response<MutableList<Category>>) {
                categoryList.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Category>>, t: Throwable) {
            }
        })
    }
}
