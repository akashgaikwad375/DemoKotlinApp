package com.webwerks.demokotlinapp.api

import com.webwerks.demokotlinapp.models.BaseResponse
import com.webwerks.demokotlinapp.models.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIInterface {

    @FormUrlEncoded
    @POST("users/login")
    fun login(@Field("email") email: String,
              @Field("password") password: String): Observable<LoginResponse>
}