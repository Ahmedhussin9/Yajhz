package com.example.domain.model.trending

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Information(

	@field:SerializedName("vehicle_registration")
	val vehicleRegistration: String? = null,

	@field:SerializedName("activity")
	val activity: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("identity_number")
	val identityNumber: String? = null,

	@field:SerializedName("vehicle_tablet_image")
	val vehicleTabletImage: String? = null,

	@field:SerializedName("tax_record")
	val taxRecord: String? = null,

	@field:SerializedName("vehicle_image")
	val vehicleImage: String? = null,

	@field:SerializedName("driving_image")
	val drivingImage: String? = null
) : Parcelable