package com.nader.userslist.base.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nader.userslist.base.database.common.Converter
import com.nader.userslist.base.database.common.DatabaseConstants
import com.nader.userslist.users.data.model.Address
import com.nader.userslist.users.data.model.Company
import com.nader.userslist.users.data.model.Geo
import com.nader.userslist.users.data.model.UserModel

@Database(
    entities = [UserModel::class, Geo::class, Company::class, Address::class],
    version = DatabaseConstants.DATABASE_VERSION
)
@TypeConverters(Converter::class)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}