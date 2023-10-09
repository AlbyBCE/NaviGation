package com.example.navifationyt

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(var id: Int, var name: String) : Parcelable

class PersonParamType() : NavType<Person>(isNullableAllowed = false) {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun get(bundle: Bundle, key: String): Person? {
        return bundle.getParcelable(key, Person::class.java)
    }

    override fun parseValue(value: String): Person {
        return Gson().fromJson(value, Person::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Person) {
       bundle.putParcelable(key, value)
    }

}