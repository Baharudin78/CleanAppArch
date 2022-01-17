package com.baharudin.cleanapparch.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.cleanapparch.data.common.util.WrapperResponse
import com.baharudin.cleanapparch.data.login.remote.data.LoginRequest
import com.baharudin.cleanapparch.data.login.remote.data.LoginResponse
import com.baharudin.cleanapparch.domain.common.base.BaseResult
import com.baharudin.cleanapparch.domain.login.entity.LoginEntity
import com.baharudin.cleanapparch.domain.login.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
    ) :ViewModel() {

    private val state = MutableStateFlow<LoginAcivityState>(LoginAcivityState.Init)
    val mState : StateFlow<LoginAcivityState>get() = state

    private fun setLoading() {
        state.value = LoginAcivityState.IsLoading(true)
    }
    private fun hideLoading() {
        state.value = LoginAcivityState.IsLoading(false)
    }
    private fun showToast(messege: String) {
        state.value = LoginAcivityState.ShowToast(messege)
    }
    private fun succesLogin(loginEntity: LoginEntity) {
        state.value = LoginAcivityState.SuccessLogin(loginEntity)
    }
    private fun errorLogin(rewResponse : WrapperResponse<LoginResponse>) {
        state.value = LoginAcivityState.ErrorLogin(rewResponse)
    }

    fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            loginUseCase.invoke(loginRequest)
                .onStart {
                    setLoading()
                }
                .catch { exception ->
                    hideLoading()
                    showToast(exception.message.toString())
                }
                .collect { result ->
                    hideLoading()
                    when(result) {
                        is BaseResult.Success -> succesLogin(result.data)
                        is BaseResult.Error -> errorLogin(result.rawRespond)
                    }

                }
        }
    }
}

sealed class LoginAcivityState{
    object Init : LoginAcivityState()
    data class IsLoading(val isLoading : Boolean) :LoginAcivityState()
    data class ShowToast(val messege : String) : LoginAcivityState()
    data class SuccessLogin(val loginEntity: LoginEntity) : LoginAcivityState()
    data class ErrorLogin(val rawResponse : WrapperResponse<LoginResponse>) : LoginAcivityState()
}