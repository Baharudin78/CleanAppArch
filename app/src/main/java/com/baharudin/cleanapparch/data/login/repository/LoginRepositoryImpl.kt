package com.baharudin.cleanapparch.data.login.repository

import com.baharudin.cleanapparch.data.common.util.WrapperResponse
import com.baharudin.cleanapparch.data.login.remote.api.LoginApi
import com.baharudin.cleanapparch.data.login.remote.data.LoginRequest
import com.baharudin.cleanapparch.data.login.remote.data.LoginResponse
import com.baharudin.cleanapparch.domain.common.base.BaseResult
import com.baharudin.cleanapparch.domain.login.LoginRepository
import com.baharudin.cleanapparch.domain.login.entity.LoginEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi
    ) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): Flow<BaseResult<LoginEntity, WrapperResponse<LoginResponse>>> {
        return flow {
            val response = loginApi.login(loginRequest)
            if (response.isSuccessful) {
                val body = response.body()!!
                val loginEntity = LoginEntity(
                    body.data?.id!!,
                    body.data?.nama!!,
                    body.data?.email!!,
                    body.data?.token!!
                )
                emit(BaseResult.Success(loginEntity))
            }else {
                val type = object : TypeToken<WrapperResponse<LoginResponse>>() {}.type
                val error : WrapperResponse<LoginResponse> = Gson().fromJson(response.errorBody()!!.charStream(), type)
                error.codeResult = response.code()
                emit(BaseResult.Error(error))
            }
        }
    }
}