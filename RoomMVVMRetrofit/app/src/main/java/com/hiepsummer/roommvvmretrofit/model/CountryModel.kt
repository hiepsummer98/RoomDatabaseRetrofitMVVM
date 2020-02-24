package com.hiepsummer.roommvvmretrofit.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Countries")
data class CountryModel (

    @PrimaryKey
    var name : String,
    var capital : String,
    var population : Int,
    var flag:String

)
