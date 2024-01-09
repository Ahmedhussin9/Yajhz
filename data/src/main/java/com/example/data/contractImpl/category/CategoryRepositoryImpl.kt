package com.example.data.contractImpl.category

import com.example.data.api.WebServices
import com.example.domain.contract.CategoryRepository
import com.example.domain.model.category.CategoryItem
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    var webServices: WebServices
):CategoryRepository {
    override suspend fun getCategories(): List<CategoryItem?>? {
        val response = webServices.getCategories().data
        return response?.data
    }
}