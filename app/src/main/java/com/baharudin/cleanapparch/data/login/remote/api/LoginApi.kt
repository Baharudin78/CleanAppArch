package com.baharudin.cleanapparch.data.login.remote.api

import com.baharudin.cleanapparch.data.common.util.WrapperResponse
import com.baharudin.cleanapparch.data.login.remote.data.LoginRequest
import com.baharudin.cleanapparch.data.login.remote.data.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ) : Response<WrapperResponse<LoginResponse>>
}