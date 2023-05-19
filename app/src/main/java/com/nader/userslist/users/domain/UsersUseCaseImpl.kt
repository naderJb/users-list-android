package com.nader.userslist.users.domain

import com.nader.userslist.base.database.UsersDao
import com.nader.userslist.base.exceptions.NoInternetException
import com.nader.userslist.base.models.APIResponse
import com.nader.userslist.base.models.Status
import com.nader.userslist.users.data.model.UserModel
import com.nader.userslist.users.data.repo.UsersRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UsersUseCaseImpl @Inject constructor(
    private val usersRepo: UsersRepo,
    private val usersDao: UsersDao
) : UsersUseCase {
    override suspend fun getUsers(): Flow<APIResponse<List<UserModel>>> =
        usersRepo.getUsers().map { status ->
            if (status.status == Status.ERROR && status.exception is NoInternetException) {
                status.apply { data = usersDao.getAll() }
            } else if (status.status == Status.SUCCESS) {
                val favoriteUsersIds = usersDao.getAll().filter { it.isFavorite }.map { it.id }
                status.data?.forEach { user ->
                    user.isFavorite = user.id in favoriteUsersIds
                }
                status.apply { data?.let { usersDao.insertAllUsers(it) } }
            } else {
                status
            }
        }

    override suspend fun updateUser(userModel: UserModel) {
        usersDao.updateUser(userModel)
    }

    override suspend fun getFavoriteUsers(): Flow<List<UserModel>> = flow {
        emit(usersDao.getAll().filter { it.isFavorite })
    }
}