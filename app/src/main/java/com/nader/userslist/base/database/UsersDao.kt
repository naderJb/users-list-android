package com.nader.userslist.base.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nader.userslist.base.database.common.DatabaseConstants
import com.nader.userslist.users.data.model.UserModel

@Dao
interface UsersDao {
    @Query("SELECT * FROM ${DatabaseConstants.TABLE_USERS}")
    suspend fun getAll(): List<UserModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUsers(userModel: List<UserModel>)

    @Update
    suspend fun updateUser(userModel: UserModel)

}