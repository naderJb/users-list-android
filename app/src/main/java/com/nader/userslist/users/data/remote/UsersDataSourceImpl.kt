package com.nader.userslist.users.data.remote

import com.nader.userslist.base.extensions.dataOrException
import com.nader.userslist.users.data.model.UserModel
import com.nader.userslist.users.data.service.UsersService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersDataSourceImpl @Inject constructor(
    private val usersService: UsersService
) : UsersDataSource {
    override suspend fun getUsers(): List<UserModel> =
        withContext(Dispatchers.IO) {
            try {
                usersService.getUsers()
                    .dataOrException("Cannot get users")
            } catch (e: Exception) {
                throw e
            }
        }
}