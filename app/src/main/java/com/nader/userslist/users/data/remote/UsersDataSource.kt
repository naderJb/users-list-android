package com.nader.userslist.users.data.remote

import com.nader.userslist.users.data.model.UserModel

interface UsersDataSource {
    suspend fun getUsers(): List<UserModel>
}