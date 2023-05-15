package com.nader.userslist.base.models

sealed class DataStatus {
    object DataLoading : DataStatus()
    object DataLoaded : DataStatus()
    data class DataError(val exception: Exception?) : DataStatus()
}