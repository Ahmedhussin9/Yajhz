package com.example.yajhz.ui.activities.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.popular.PopularItem
import com.example.yajhz.databinding.ItemPopularBinding

class PopularSellersAdapter(var popularList:List<PopularItem?>?=null):RecyclerView.Adapter<PopularSellersAdapter.ViewHolder> (){
    class ViewHolder(private var viewBinding:ItemPopularBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(popularItem: PopularItem?){
            viewBinding.popularItem = popularItem
            viewBinding.invalidateAll()
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =popularList!![position]
        holder.bind(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =ItemPopularBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = popularList?.size ?:0
    fun bindPopularSellers(loadedPopularSellers:List<PopularItem?>?){
        popularList = loadedPopularSellers
        notifyDataSetChanged()
    }


}