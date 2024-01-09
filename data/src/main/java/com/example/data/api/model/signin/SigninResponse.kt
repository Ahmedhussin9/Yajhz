package com.example.data.api.model.signin

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.domain.model.signin.Data
import com.google.gson.annotations.SerializedName

@Parcelize
data class SigninResponse(

    @field:SerializedName("response_code")
	val responseCode: Int? = null,

    @field:SerializedName("data")
	val data: Data? = null,

    @field:SerializedName("success")
	val success: Boolean? = null,

    @field:SerializedName("message")
	val message: String? = null
) : Parcelable