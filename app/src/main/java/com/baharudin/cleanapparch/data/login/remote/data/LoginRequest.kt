package com.baharudin.cleanapparch.data.login.remote.data

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email")
    val email : String,
    @SerializedName("password")
    val password : String
)
