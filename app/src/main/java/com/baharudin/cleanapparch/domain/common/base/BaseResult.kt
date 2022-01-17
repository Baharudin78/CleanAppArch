package com.baharudin.cleanapparch.domain.common.base

sealed class BaseResult<out T : Any, out U : Any> {
    data class Success<T : Any>(val data : T) : BaseResult<T, Nothing>()
    data class Error<U : Any> (val rawRespond : U) : BaseResult<Nothing, U>()
}
