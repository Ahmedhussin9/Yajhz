package com.example.data.contractImpl.popular

import com.example.domain.contract.PopularSellersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class Di {
    @Provides
    fun providePopularSellersRepository(popularSellersImpl: PopularSellersImpl):PopularSellersRepository{
        return popularSellersImpl
    }
}