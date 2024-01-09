package com.example.domain.usecases.popularusecase

import com.example.domain.contract.PopularSellersRepository
import com.example.domain.contract.SignInRepository
import com.example.domain.model.signup.SignUpResponse
import com.example.domain.contract.SignUpRepository
import com.example.domain.model.popular.PopularItem
import com.example.domain.model.popular.PopularResponse
import com.example.domain.model.signin.SigninResponse
import javax.inject.Inject

class PopularUseCase @Inject constructor(
    var popularSellersRepository: PopularSellersRepository
) {
    suspend fun invoke():List<PopularItem?>?{
     return popularSellersRepository.getPopularSellers()
    }
}