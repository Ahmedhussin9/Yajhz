package com.example.domain.contract

import com.example.domain.model.trending.TrendingItem

interface TrendingRepository {
    suspend fun getTrendingItem():List<TrendingItem?>?
}