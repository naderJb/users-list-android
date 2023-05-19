package com.nader.userslist.users.domain

import com.nader.userslist.base.models.APIResponse
import com.nader.userslist.users.data.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UsersUseCase {
    suspend fun getUsers(): Flow<APIResponse<List<UserModel>>>
    suspend fun updateUser(userModel: UserModel)
    suspend fun getFavoriteUsers(): Flow<List<UserModel>>
}