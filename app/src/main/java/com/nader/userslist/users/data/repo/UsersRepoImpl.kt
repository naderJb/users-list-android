package com.nader.userslist.users.data.repo

import com.nader.userslist.base.models.APIResponse
import com.nader.userslist.users.data.model.UserModel
import com.nader.userslist.users.data.remote.UsersDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UsersRepoImpl @Inject constructor(
    private val usersDataSource: UsersDataSource
) : UsersRepo {
    override suspend fun getUsers(): Flow<APIResponse<List<UserModel>>> = flow {
        emit(APIResponse.loading())
        try {
            val response = usersDataSource.getUsers()
            emit(APIResponse.success(response))
        } catch (e: Exception) {
            emit(APIResponse.error(e))
        }
    }
}