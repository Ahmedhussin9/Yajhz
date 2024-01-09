package com.example.data.contractImpl.popular

import com.example.data.api.WebServices
import com.example.domain.contract.PopularSellersRepository
import com.example.domain.model.popular.PopularItem
import com.example.domain.model.popular.PopularResponse
import javax.inject.Inject

class PopularSellersImpl @Inject constructor(
    var webServices: WebServices
):PopularSellersRepository {
    override suspend fun getPopularSellers():List<PopularItem?>? {
       val response = webServices.getPopularSellers()
        return response.data
    }
}