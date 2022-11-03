package com.example.sharedviewmodelprac.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel: ViewModel() {
    val backSetList:List<Int> = mutableListOf<Int>(1,3,5)
    val chestSetList:List<Int> = mutableListOf<Int>(2,4,6)

    private val _wholeSet = MutableLiveData<Int>(0)
    val wholeSet: LiveData<Int> = _wholeSet

    fun updateWholeSet(){
        _wholeSet.value = (backSet.value?:0) + (chestSet.value?:0)+(wholeLegSet.value?:0)
    }

    private fun updateWholeLegSet(){
        _wholeLegSet.value = (legSet0.value?:0)+(legSet1.value?:0)+(legSet2.value?:0)
        updateWholeSet()
    }

    private val _backSet = MutableLiveData<Int>(0)
    val backSet: LiveData<Int> = _backSet


    private val _chestSet = MutableLiveData<Int>(0)
    val chestSet: LiveData<Int> = _chestSet


    private val _legSet0 = MutableLiveData<Int>(0)
    val legSet0 : LiveData<Int> =_legSet0
    private val _legSet1 = MutableLiveData<Int>(0)
    val legSet1 : LiveData<Int> =_legSet1
    private val _legSet2 = MutableLiveData<Int>(0)
    val legSet2 : LiveData<Int> =_legSet2

    private val _wholeLegSet = MutableLiveData<Int>(0)
    val wholeLegSet : LiveData<Int> =_wholeLegSet


    fun setBackSet(set:Int){
        _backSet.value = set
        updateWholeSet()
        Log.d("sharedVM","등 is set to $set")
    }

    fun setChestSet(set:Int){
        _chestSet.value = set
        updateWholeSet()
        Log.d("sharedVM","가슴 is set to $set")
    }

    fun setLeg0(set:Int){
        _legSet0.value = set
        updateWholeLegSet()
        Log.d("sharedVM","하체0 is set to $set")
    }

    fun setLeg1(set:Int){
        _legSet1.value = set
        updateWholeLegSet()
        Log.d("sharedVM","하체1 is set to $set")
    }fun setLeg2(set:Int){
        _legSet2.value = set
        updateWholeLegSet()
        Log.d("sharedVM","하체2 is set to $set")
    }
    fun reset(){
        setBackSet(backSetList[0])
        setChestSet(chestSetList[0])
        setLeg0(0)
        setLeg1(0)
        setLeg2(0)
//        _backSet.value = backSetList[0]
//        _chestSet.value = chestSetList[0]
//        _legSet0.value = 0
//        _legSet1.value = 0
//        _legSet2.value = 0
    }
    init{
        reset()
    }
}