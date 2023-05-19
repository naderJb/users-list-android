package com.nader.userslist.base.di

import android.content.Context
import androidx.room.Room
import com.nader.userslist.base.database.UsersDao
import com.nader.userslist.base.database.UsersDatabase
import com.nader.userslist.base.database.common.DatabaseConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): UsersDatabase =
        Room.databaseBuilder(
            context,
            UsersDatabase::class.java,
            DatabaseConstants.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun providesUsersDao(usersDatabase: UsersDatabase): UsersDao = usersDatabase.getUsersDao()
}