package com.hiepsummer.roommvvmretrofit.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hiepsummer.roommvvmretrofit.model.CountryModel

@Database(entities = [(CountryModel::class)], version = 1)
abstract class CountryDatabase : RoomDatabase(){

    abstract fun countryDao() : CountryDao
}


