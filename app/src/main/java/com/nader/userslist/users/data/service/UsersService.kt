package com.nader.userslist.users.data.service

import com.nader.userslist.users.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface UsersService {
    @GET(GET_USERS)
    suspend fun getUsers(): Response<List<UserModel>>


    companion object {
        const val GET_USERS = "users"
    }
}