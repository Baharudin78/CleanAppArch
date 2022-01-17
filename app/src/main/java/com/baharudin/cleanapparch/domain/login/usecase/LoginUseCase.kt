package com.baharudin.cleanapparch.domain.login.usecase

import com.baharudin.cleanapparch.data.common.util.WrapperResponse
import com.baharudin.cleanapparch.data.login.remote.data.LoginRequest
import com.baharudin.cleanapparch.data.login.remote.data.LoginResponse
import com.baharudin.cleanapparch.domain.common.base.BaseResult
import com.baharudin.cleanapparch.domain.login.LoginRepository
import com.baharudin.cleanapparch.domain.login.entity.LoginEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
    ) {
    suspend fun invoke(
        loginRequest: LoginRequest
    ) : Flow<BaseResult<LoginEntity, WrapperResponse<LoginResponse>>> {
        return loginRepository.login(loginRequest)
    }
}