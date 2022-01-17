package com.baharudin.cleanapparch.data.common.util

import com.google.gson.annotations.SerializedName

data class WrapperListResponse<T>(
    var codeResult : Int ,
    @SerializedName("message") var message : String,
    @SerializedName("status") var status : Boolean,
    @SerializedName("error") var error : List<String>? = null,
    @SerializedName("data") var data : List<T>? = null
)

data class WrapperResponse<T> (
    var codeResult : Int ,
    @SerializedName("message") var message : String,
    @SerializedName("status") var status : Boolean,
    @SerializedName("error") var error : List<String>? = null,
    @SerializedName("data") var data : T? = null
)


