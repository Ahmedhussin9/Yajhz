package com.example.yajhz.ui.activities.home

import androidx.lifecycle.MutableLiveData
import com.example.domain.model.category.CategoryItem
import com.example.domain.model.popular.PopularItem
import com.example.domain.model.popular.PopularResponse
import com.example.domain.model.trending.TrendingItem
import com.example.yajhz.common.SingleLiveEvent
class HomeContract {
    interface ViewModel{
         fun invoke(action: Action)
        val state: MutableLiveData<HomeContract.State>
        val event: SingleLiveEvent<HomeContract.Event>
    }

    sealed class Event{

    }
    sealed class State {
        class PopularSellersSuccess(var data:List<PopularItem?>?):State()
        class CategorySuccess(var data:List<CategoryItem?>?):State()
        class TrendingSuccess(var data:List<TrendingItem?>?):State()
    }
    sealed class Action{
        class LoadCategory():Action()
        class LoadPopular():Action()
        class LoadTrending():Action()
    }
}