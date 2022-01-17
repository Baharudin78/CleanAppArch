package com.baharudin.cleanapparch.domain.login

import com.baharudin.cleanapparch.data.common.util.WrapperResponse
import com.baharudin.cleanapparch.data.login.remote.data.LoginRequest
import com.baharudin.cleanapparch.data.login.remote.data.LoginResponse
import com.baharudin.cleanapparch.domain.common.base.BaseResult
import com.baharudin.cleanapparch.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(
        loginRequest: LoginRequest
    ) : Flow<BaseResult<LoginEntity, WrapperResponse<LoginResponse>>>
}