package com.example.data.contractImpl.category

import com.example.domain.contract.CategoryRepository
import com.example.domain.contract.PopularSellersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class Di {
    @Provides
    fun provideCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl):CategoryRepository{
        return categoryRepositoryImpl
    }
}