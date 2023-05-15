package com.nader.userslist.base.extensions

import com.nader.userslist.base.exceptions.APIException
import retrofit2.Response


fun <R> Response<R>.dataOrException(errorMessage: String): R {
    return when (isSuccessful) {
        true -> body() ?: throw Exception(errorMessage)
        else -> throw APIException(errorMessage)
    }
}