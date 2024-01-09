package com.example.yajhz.ui.activities.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.popular.PopularItem
import com.example.domain.model.trending.TrendingItem
import com.example.yajhz.databinding.ItemPopularBinding
import com.example.yajhz.databinding.ItemTrendingBinding

class TrendingSellersAdapter(var trendingList:List<TrendingItem?>?=null):RecyclerView.Adapter<TrendingSellersAdapter.ViewHolder> (){
    class ViewHolder(private var viewBinding:ItemTrendingBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(trendingItem: TrendingItem?){
            viewBinding.trendingItem = trendingItem
            viewBinding.invalidateAll()
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =trendingList!![position]
        holder.bind(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =ItemTrendingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = trendingList?.size ?:0
    fun bindTrendingSellers(loadedTrendingSellers:List<TrendingItem?>?){
        trendingList = loadedTrendingSellers
        notifyDataSetChanged()
    }


}