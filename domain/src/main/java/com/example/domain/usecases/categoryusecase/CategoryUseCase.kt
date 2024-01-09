package com.example.domain.usecases.categoryusecase

import com.example.domain.contract.CategoryRepository
import com.example.domain.contract.PopularSellersRepository
import com.example.domain.contract.SignInRepository
import com.example.domain.model.signup.SignUpResponse
import com.example.domain.contract.SignUpRepository
import com.example.domain.model.category.CategoryItem
import com.example.domain.model.popular.PopularItem
import com.example.domain.model.popular.PopularResponse
import com.example.domain.model.signin.SigninResponse
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    var categoryRepository: CategoryRepository
) {
    suspend fun invoke():List<CategoryItem?>?{
     return categoryRepository.getCategories()
    }
}