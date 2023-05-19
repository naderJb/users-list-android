package com.nader.userslist.base.database.common

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.nader.userslist.users.data.model.Address
import com.nader.userslist.users.data.model.Company
import com.nader.userslist.users.data.model.Geo

class Converter {
    private var gson: Gson = Gson()

    @TypeConverter
    fun toAddress(address: String): Address? = try {
        gson.fromJson(address, Address::class.java)
    } catch (_: Exception) {
        null
    }

    @TypeConverter
    fun fromAddress(address: Address): String = gson.toJson(address)


    @TypeConverter
    fun toCompany(company: String): Company? = try {
        gson.fromJson(company, Company::class.java)
    } catch (_: Exception) {
        null
    }

    @TypeConverter
    fun fromCompany(company: Company): String = gson.toJson(company)


    @TypeConverter
    fun toGeo(geo: String): Geo? = try {
        gson.fromJson(geo, Geo::class.java)
    } catch (_: Exception) {
        null
    }

    @TypeConverter
    fun fromGeo(geo: Geo): String = gson.toJson(geo)

}