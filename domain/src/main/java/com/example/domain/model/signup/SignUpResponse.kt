package com.example.domain.model.signup

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class SignUpResponse(

    @field:SerializedName("response_code")
	val responseCode: Int? = null,

    @field:SerializedName("data")
	val data: Data? = null,

    @field:SerializedName("success")
	val success: Boolean? = null,

    @field:SerializedName("message")
	val message: String? = null
) : Parcelable