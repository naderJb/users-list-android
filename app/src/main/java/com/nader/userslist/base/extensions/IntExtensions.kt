package com.nader.userslist.base.extensions

fun Int?.safe(defaultValue: Int = 0) = this ?: defaultValue