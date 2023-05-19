package com.nader.userslist.users.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.nader.userslist.base.database.common.DatabaseConstants
import com.nader.userslist.base.database.common.DatabaseConstants.TABLE_ADDRESS
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = TABLE_ADDRESS)
data class Address(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(DatabaseConstants.ADDRESS_ID)
    val id: Int,
    @SerializedName("city")
    @ColumnInfo(DatabaseConstants.ADDRESS_CITY)
    val city: String,

    @SerializedName("geo")
    @ColumnInfo(DatabaseConstants.ADDRESS_GEO)
    val geo: Geo,

    @SerializedName("street")
    @ColumnInfo(DatabaseConstants.ADDRESS_STREET)
    val street: String,

    @SerializedName("suite")
    @ColumnInfo(DatabaseConstants.ADDRESS_SUITE)
    val suite: String,

    @SerializedName("zipcode")
    @ColumnInfo(DatabaseConstants.ADDRESS_ZIPCODE)
    val zipCode: String
) : Parcelable