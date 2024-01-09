package com.example.yajhz.ui.activities.home

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.domain.model.category.CategoryItem
import com.example.domain.model.popular.PopularItem
import com.example.domain.model.trending.TrendingItem
import com.example.yajhz.R
import com.example.yajhz.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityHomeBinding
    private lateinit var viewModel:HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        makeStatusBarTransparentAndIconsClear()
        initViews()
        loadActions()
        observeLiveData()

    }

    private fun loadActions() {
        viewModel.invoke(HomeContract.Action.LoadPopular())
        viewModel.invoke(HomeContract.Action.LoadCategory())
        viewModel.invoke(HomeContract.Action.LoadTrending())
    }

    private fun observeLiveData() {
        viewModel.state.observe(this){
            when(it){
                is HomeContract.State.PopularSellersSuccess->loadPopularSellers(it.data)
                is HomeContract.State.CategorySuccess->loadCategories(it.data)
                is HomeContract.State.TrendingSuccess->loadTrending(it.data)
            }
        }
        viewModel.errorrLiveData.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
    private val trendingSellersAdapter = TrendingSellersAdapter()
    private fun loadTrending(data: List<TrendingItem?>?) {
        trendingSellersAdapter.bindTrendingSellers(data)
    }

    private val categoryAdapter = CategoryAdapter()
    private fun loadCategories(data: List<CategoryItem?>?) {
        categoryAdapter.bindCategory(data)
    }

    private val popularSellersAdapter=PopularSellersAdapter()
    private fun loadPopularSellers(data:List< PopularItem?>?) {
        popularSellersAdapter.bindPopularSellers(data)
    }

    private fun initViews() {
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        viewBinding.content.popularRecyclerView.adapter = popularSellersAdapter
        viewBinding.content.categoryRecyclerView.adapter = categoryAdapter
        viewBinding.content.trendingRecyclerView.adapter = trendingSellersAdapter

    }

    private fun makeStatusBarTransparentAndIconsClear() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        window.statusBarColor = Color.TRANSPARENT
    }
}