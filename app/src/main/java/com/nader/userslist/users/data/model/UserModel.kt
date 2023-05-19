package com.nader.userslist.users.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.nader.userslist.base.database.common.DatabaseConstants
import com.nader.userslist.base.database.common.DatabaseConstants.TABLE_USERS
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = TABLE_USERS)
data class UserModel(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(DatabaseConstants.USER_ID)
    val id: Int,
    @SerializedName("address")
    @ColumnInfo(DatabaseConstants.USER_ADDRESS)
    val address: Address,
    @SerializedName("company")
    @ColumnInfo(DatabaseConstants.USER_COMPANY)
    val company: Company,
    @SerializedName("email")
    @ColumnInfo(DatabaseConstants.USER_EMAIL)
    val email: String,
    @SerializedName("name")
    @ColumnInfo(DatabaseConstants.USER_NAME)
    val name: String,
    @SerializedName("phone")
    @ColumnInfo(DatabaseConstants.USER_PHONE)
    val phone: String,
    @SerializedName("username")
    @ColumnInfo(DatabaseConstants.USER_USERNAME)
    val username: String,
    @SerializedName("website")
    @ColumnInfo(DatabaseConstants.USER_WEBSITE)
    val website: String,
    @ColumnInfo(DatabaseConstants.USER_FAVORITE)
    var isFavorite: Boolean = false
) : Parcelable