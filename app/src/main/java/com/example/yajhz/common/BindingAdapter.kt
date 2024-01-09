package com.example.yajhz.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:Error")
fun bindErrorInTextInputLayout(textInputLayout: TextInputLayout,error:String?){
    textInputLayout.error = error
}
@BindingAdapter("url")
fun bindImageWithUrl(imageView: ImageView, url:String){
    Glide.with(imageView).load(url).into(imageView)
}