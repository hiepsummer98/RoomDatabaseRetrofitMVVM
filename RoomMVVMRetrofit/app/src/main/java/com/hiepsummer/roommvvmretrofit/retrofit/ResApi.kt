package com.hiepsummer.roommvvmretrofit.retrofit

import com.hiepsummer.roommvvmretrofit.model.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {

    @GET("all")
    fun getAllCountries() : Call<List<CountryModel>>
}