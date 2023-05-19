package com.nader.userslist.base.database.common

object DatabaseConstants {
    const val DATABASE_VERSION = 1

    const val DATABASE_NAME = "users_db"
    const val TABLE_USERS = "users_table"
    const val TABLE_ADDRESS = "address_table"
    const val TABLE_GEO = "geo_table"
    const val TABLE_COMPANY = "company_table"
    const val TABLE_FAVORITE = "favorite_table"


    /******************** users Table Fields  ********************/


    const val USER_ID = "id"
    const val USER_ADDRESS = "address"
    const val USER_COMPANY = "company"
    const val USER_EMAIL = "email"
    const val USER_NAME = "name"
    const val USER_PHONE = "phone"
    const val USER_USERNAME = "username"
    const val USER_WEBSITE = "website"
    const val USER_FAVORITE = "favorite"

    /******************** address Table Fields  ********************/


    const val ADDRESS_ID = "id"
    const val ADDRESS_CITY = "city"
    const val ADDRESS_GEO = "geo"
    const val ADDRESS_STREET = "street"
    const val ADDRESS_SUITE = "suite"
    const val ADDRESS_ZIPCODE = "zipcode"

    /******************** geo Table Fields  ********************/

    const val GEO_ID = "id"
    const val GEO_LAT = "lat"
    const val GEO_LNG = "lng"

    /******************** company Table Fields  ********************/

    const val COMPANY_ID = "id"
    const val COMPANY_BS = "bs"
    const val COMPANY_CATCH_PHRASE = "catchPhrase"
    const val COMPANY_NAME = "name"
}