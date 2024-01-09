package com.example.domain.model.trending

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class TrendingItem(

	@field:SerializedName("trending")
	val trending: Int? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("appointments")
	val appointments: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("is_favorite")
	val isFavorite: Boolean? = null,

	@field:SerializedName("distance")
	val distance: String? = null,

	@field:SerializedName("lng")
	val lng: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("type")
	val type: Int? = null,

	@field:SerializedName("token")
	val token: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("rate")
	val rate: String? = null,

	@field:SerializedName("product_categories")
	val productCategories: List<ProductCategoriesItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("information")
	val information: Information? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null,

	@field:SerializedName("popular")
	val popular: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
) : Parcelable