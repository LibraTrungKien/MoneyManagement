package com.example.moneymanagement.presentation.view.homeactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private var money = MutableLiveData<String>()
    private val totalMoney : LiveData<String> get() = money





}