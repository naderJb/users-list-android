package com.nader.userslist.users.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.nader.userslist.base.database.common.DatabaseConstants
import com.nader.userslist.base.database.common.DatabaseConstants.TABLE_GEO
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = TABLE_GEO)
data class Geo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(DatabaseConstants.GEO_ID)
    val id: Int,
    @SerializedName("lat")
    @ColumnInfo(DatabaseConstants.GEO_LAT)
    val lat: String,
    @SerializedName("lng")
    @ColumnInfo(DatabaseConstants.GEO_LNG)
    val lng: String
) : Parcelable