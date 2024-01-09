package com.example.yajhz.ui.activities.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.categoryusecase.CategoryUseCase
import com.example.domain.usecases.popularusecase.PopularUseCase
import com.example.domain.usecases.trendingusecase.TrendingUseCase
import com.example.yajhz.common.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private var popularUseCase: PopularUseCase,
    private var categoryUseCase: CategoryUseCase,
    private var trendingUseCase: TrendingUseCase
) :ViewModel(),HomeContract.ViewModel {
    private val _state=MutableLiveData<HomeContract.State>()
    override val state: MutableLiveData<HomeContract.State> =_state
    private val _event =SingleLiveEvent<HomeContract.Event>()
    override val event: SingleLiveEvent<HomeContract.Event> =_event
    var errorrLiveData = MutableLiveData<String?>()
    override fun invoke(action: HomeContract.Action) {
        when(action){
            is HomeContract.Action.LoadPopular->loadPopular()
            is HomeContract.Action.LoadCategory->loadCategory()
            is HomeContract.Action.LoadTrending->loadTrending()
        }
    }

    private  fun loadTrending() {
        viewModelScope.launch {
            try {
                val data = trendingUseCase.invoke()
                _state.postValue(HomeContract.State.TrendingSuccess(data))
            }catch (e:Exception){
                if (e.message=="Chain validation failed"){
                    loadTrending()
                }else{
                    errorrLiveData.postValue(e.message)
                }

            }

        }
    }

    private fun  loadCategory(){
        viewModelScope.launch {
            try {
                val data = categoryUseCase.invoke()
                _state.postValue(HomeContract.State.CategorySuccess(data))
            }catch (e:Exception){
                if (e.message=="Chain validation failed"){
                    loadCategory()
                }else{
                    errorrLiveData.postValue(e.message)
                }
            }

        }

    }
    private  fun loadPopular() {
        viewModelScope.launch {
            try {
                val data = popularUseCase.invoke()
                _state.postValue(HomeContract.State.PopularSellersSuccess(data))
            }catch (e:Exception){
                if (e.message=="Chain validation failed"){
                    loadPopular()
                }else{
                    errorrLiveData.postValue(e.message)
                }
            }

        }
    }


}