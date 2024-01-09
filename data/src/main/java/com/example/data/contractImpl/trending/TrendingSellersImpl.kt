package com.example.data.contractImpl.trending

import com.example.data.api.WebServices
import com.example.domain.contract.TrendingRepository
import com.example.domain.model.trending.TrendingItem
import javax.inject.Inject

class TrendingSellersImpl @Inject constructor(
    var webServices: WebServices
):TrendingRepository {
    override suspend fun getTrendingItem(): List<TrendingItem?>? {
       return webServices.getTrendingSellers().data
    }
}