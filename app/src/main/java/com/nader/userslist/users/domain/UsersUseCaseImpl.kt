package com.nader.userslist.users.domain

import com.nader.userslist.base.models.APIResponse
import com.nader.userslist.users.data.model.UserModel
import com.nader.userslist.users.data.repo.UsersRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersUseCaseImpl @Inject constructor(
    private val usersRepo: UsersRepo
) : UsersUseCase {
    override suspend fun getUsers(): Flow<APIResponse<List<UserModel>>> = usersRepo.getUsers()
}