package com.example.yajhz.ui.activities.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.category.CategoryItem
import com.example.domain.model.popular.PopularItem
import com.example.yajhz.databinding.ItemCategoryBinding
import com.example.yajhz.databinding.ItemPopularBinding

class CategoryAdapter(var categoryList:List<CategoryItem?>?=null):RecyclerView.Adapter<CategoryAdapter.ViewHolder> (){
    class ViewHolder(private var viewBinding:ItemCategoryBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(categoryItem: CategoryItem?){
            viewBinding.categoryItem = categoryItem
            viewBinding.invalidateAll()
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =categoryList!![position]
        holder.bind(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = categoryList?.size ?:0
    fun bindCategory(loadedCategories:List<CategoryItem?>?){
        categoryList = loadedCategories
        notifyDataSetChanged()
    }


}