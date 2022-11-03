package com.example.viewmodel_prac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val _curPoint =MutableLiveData<Int>(0)
    val curPoint: LiveData<Int> get()=_curPoint

    private val _isTwenty=MutableLiveData<Boolean>(false)
    val isTwenty:LiveData<Boolean> get() = _isTwenty

    fun reInit(){
        _curPoint.value=0
        _isTwenty.value=false
    }

    fun pointUp(){
        _curPoint.value = (_curPoint.value)?.plus(1)
        if(_curPoint.value!! >= maxCount){
            _curPoint.value= maxCount
            _isTwenty.value=true
        }
    }




}