package com.webwerks.demokotlinapp.models

import com.google.gson.annotations.SerializedName

class LoginResponse: BaseResponse(){

    @SerializedName("data")
    lateinit var user: User
}