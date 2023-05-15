package com.nader.userslist.users.di

import com.nader.userslist.users.data.remote.UsersDataSource
import com.nader.userslist.users.data.remote.UsersDataSourceImpl
import com.nader.userslist.users.data.repo.UsersRepo
import com.nader.userslist.users.data.repo.UsersRepoImpl
import com.nader.userslist.users.data.service.UsersService
import com.nader.userslist.users.domain.UsersUseCase
import com.nader.userslist.users.domain.UsersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class UsersModule {
    @Provides
    fun provideUsersService(retrofit: Retrofit): UsersService =
        retrofit.create(UsersService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class UsersBindModule {

        @Binds
        abstract fun binUsersDataSource(
            usersDataSourceImpl: UsersDataSourceImpl
        ): UsersDataSource

        @Binds
        abstract fun bindUsersRepository(
            usersRepoImpl: UsersRepoImpl
        ): UsersRepo

        @Binds
        abstract fun bindUsersUseCase(
            usersUseCaseImpl: UsersUseCaseImpl
        ): UsersUseCase
    }
}