package com.example.domain.model.category

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Data(

	@field:SerializedName("cart_count")
	val cartCount: Int? = null,

	@field:SerializedName("data")
	val data: List<CategoryItem?>? = null
) : Parcelable