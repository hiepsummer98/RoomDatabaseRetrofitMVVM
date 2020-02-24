package com.hiepsummer.roommvvmretrofit.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.hiepsummer.roommvvmretrofit.database.CountryDatabase

class RoomViewModelKotlinSampleApplication : Application() {

    companion object {
        var database: CountryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, CountryDatabase::class.java, "country_db").fallbackToDestructiveMigration().build()
    }
}