package com.hiepsummer.roommvvmretrofit.activity

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.hiepsummer.roommvvmretrofit.model.CountryModel
import com.hiepsummer.roommvvmretrofit.retrofit.RestApi
import com.hiepsummer.roommvvmretrofit.viewmodel.RoomViewModelKotlinSampleApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityRepository {
    val BASE_URL = "https://restcountries.eu/rest/v2/"
    val TAG = MainActivityRepository::class.java.simpleName

    fun getCountries(): LiveData<List<CountryModel>> {
        return RoomViewModelKotlinSampleApplication.database!!.countryDao().getAllCountries()
    }

    fun ApiCallAndPutInDB() {
        val gson = Gson()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()

        val restApi = retrofit.create<RestApi>(RestApi::class.java)

        restApi.getAllCountries().enqueue(object : Callback<List<CountryModel>> {

            override fun onFailure(call: Call<List<CountryModel>>?, t: Throwable?) {
                Log.e(TAG, "OOPS!! something went wrong..")
            }

            override fun onResponse(
                call: Call<List<CountryModel>>?,
                response: Response<List<CountryModel>>?
            ) {

                Log.e(TAG, response!!.body().toString())
                when (response.code()) {
                    200 -> {
                        Thread(Runnable {

                            RoomViewModelKotlinSampleApplication.database!!.countryDao()
                                .deleteAllCountries()
                            RoomViewModelKotlinSampleApplication.database!!.countryDao()
                                .insertAllCountries(response.body()!!)

                        }).start()
                    }
                }

            }
        })


    }
}