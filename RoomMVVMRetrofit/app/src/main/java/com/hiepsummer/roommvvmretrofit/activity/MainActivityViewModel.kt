package com.hiepsummer.roommvvmretrofit.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hiepsummer.roommvvmretrofit.model.CountryModel

class MainActivityViewModel :ViewModel(){
    lateinit var mainActivityRepository: MainActivityRepository

    init {
        mainActivityRepository = MainActivityRepository()
    }

    fun getAllCountryList(): LiveData<List<CountryModel>>
    {
        return mainActivityRepository.getCountries()
    }

    fun getCountriesFromAPIAndStore()
    {
        mainActivityRepository.ApiCallAndPutInDB()
    }


}