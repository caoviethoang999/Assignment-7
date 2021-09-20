package com.example.hoangcv2_assiagnment.viewmodel

import com.example.hoangcv2_assiagnment.api.ProductService

class ProductRepository constructor(private val productService: ProductService) {

    fun getAllProduct() = productService.getProduct()
    fun getCategory() = productService.getCategory()
    fun getProductByCategory(categoryId:Int) = productService.getProductByCategory(categoryId)

}
