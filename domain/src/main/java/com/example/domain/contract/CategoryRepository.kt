package com.example.domain.contract

import com.example.domain.model.category.CategoryItem

interface CategoryRepository {
    suspend fun getCategories():List<CategoryItem?>?
}