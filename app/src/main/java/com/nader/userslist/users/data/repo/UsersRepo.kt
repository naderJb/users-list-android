package com.nader.userslist.users.data.repo

import com.nader.userslist.base.models.APIResponse
import com.nader.userslist.users.data.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UsersRepo {
    suspend fun getUsers(): Flow<APIResponse<List<UserModel>>>
}