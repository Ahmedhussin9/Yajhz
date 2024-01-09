package com.example.domain.contract

import com.example.domain.model.popular.PopularItem
import com.example.domain.model.popular.PopularResponse

interface PopularSellersRepository {
    suspend fun getPopularSellers( ):List<PopularItem?>?
}