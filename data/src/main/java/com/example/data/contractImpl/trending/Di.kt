package com.example.data.contractImpl.trending

import com.example.domain.contract.PopularSellersRepository
import com.example.domain.contract.TrendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class Di {
    @Provides
    fun provideTrendingSellersRepository(trendingSellersImpl: TrendingSellersImpl):TrendingRepository{
        return trendingSellersImpl
    }
}