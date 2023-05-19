package com.nader.userslist.users.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.nader.userslist.base.database.common.DatabaseConstants
import com.nader.userslist.base.database.common.DatabaseConstants.TABLE_COMPANY
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = TABLE_COMPANY)
data class Company(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(DatabaseConstants.COMPANY_ID)
    val id: Int,
    @SerializedName("bs")
    @ColumnInfo(DatabaseConstants.COMPANY_BS)
    val bs: String,
    @SerializedName("catchPhrase")
    @ColumnInfo(DatabaseConstants.COMPANY_CATCH_PHRASE)
    val catchPhrase: String,
    @SerializedName("name")
    @ColumnInfo(DatabaseConstants.COMPANY_NAME)
    val name: String
) : Parcelable