package com.hiepsummer.roomretrofitmvvm.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hiepsummer.roomretrofitmvvm.mvvm.model.UserResponseModel
import com.hiepsummer.roomretrofitmvvm.repository.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var mainRepository = MainRepository.getInstance()

    fun requestGetUser(page: String) {
        mainRepository.requestGetUser(page)
    }

    fun responseGetUser(): MutableLiveData<UserResponseModel> {
        return mainRepository.responseGetUser()
    }

}