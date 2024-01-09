package com.example.domain.usecases.trendingusecase

import com.example.domain.contract.PopularSellersRepository
import com.example.domain.contract.SignInRepository
import com.example.domain.model.signup.SignUpResponse
import com.example.domain.contract.SignUpRepository
import com.example.domain.contract.TrendingRepository
import com.example.domain.model.popular.PopularItem
import com.example.domain.model.popular.PopularResponse
import com.example.domain.model.signin.SigninResponse
import com.example.domain.model.trending.TrendingItem
import javax.inject.Inject

class TrendingUseCase @Inject constructor(
    var trendingRepository: TrendingRepository
) {
    suspend fun invoke():List<TrendingItem?>?{
     return trendingRepository.getTrendingItem()
    }
}