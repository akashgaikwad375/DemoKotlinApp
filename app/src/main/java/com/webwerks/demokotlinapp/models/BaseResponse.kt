package com.webwerks.demokotlinapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class BaseResponse : Serializable {

    @SerializedName("status")
    var status: String = ""

    @SerializedName("message")
    var message: String = ""

    @SerializedName("user_msg")
    var userMsg: String = ""
}