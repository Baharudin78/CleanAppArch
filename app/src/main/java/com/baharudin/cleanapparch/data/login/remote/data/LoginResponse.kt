package com.baharudin.cleanapparch.data.login.remote.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    var id : Int? = null,
    @SerializedName("nama")
    var nama : String? = null,
    @SerializedName("email")
    var email : String? = null,
    @SerializedName("token")
    var token : String? = null
)
