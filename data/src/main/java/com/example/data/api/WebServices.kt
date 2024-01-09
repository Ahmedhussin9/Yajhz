package com.example.data.api
import com.example.domain.model.category.CategoryResponse
import com.example.domain.model.popular.PopularResponse
import com.example.domain.model.signin.SigninResponse
import com.example.domain.model.signup.SignUpResponse
import com.example.domain.model.trending.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface WebServices {
    @POST("client-register")
    @Headers("lang: en")
    suspend fun signUp(
        @Query("name")
        name:String,
        @Query("email")
        email: String,
        @Query("password")
        password:String,
        @Query("phone")
        phone:String
   ): SignUpResponse
    @POST("login")
    @Headers("lang: en","Accept: application/json")
    suspend fun signIn  (
        @Query("email")
        email: String,
        @Query("password")
        password:String
    ): SigninResponse
    @GET("popular-sellers")
    @Headers("Accept: application/json","lang: ar" )
    suspend fun getPopularSellers  (

        @Query("lat")
        lat: Double =29.1931,
        @Query("lng")
        lng:Double=30.6421,
        @Query("filter")
        filter:Int=1,
    ): PopularResponse

    @GET("home-base-categories")
    @Headers("Accept: application/json","lang: ar" )
    suspend fun getCategories  (
    ): CategoryResponse

    @GET("trending-sellers")
    @Headers("Accept: application/json","lang: ar" )
    suspend fun getTrendingSellers  (
        @Query("lat")
        lat: Double =29.1931,
        @Query("lng")
        lng:Double=30.6421,
        @Query("filter")
        filter:Int=1,
    ): TrendingResponse

}