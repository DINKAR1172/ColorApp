package com.example.colorapp.Viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colorapp.Constant.Graph
import com.example.colorapp.Model.Colours
import com.example.colorapp.Model.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ColorViewModel(private val _CRepository:Repository=Graph.Crepository):ViewModel() {
    lateinit var ALLDATA:Flow<List<Colours>>
    init {
        getAllData()
    }
    fun getAllData():Flow<List<Colours>>{
        return _CRepository.GetAllData()
    }
    fun getDataById(ID:Long):Flow<Colours>{
        return _CRepository.GetDataById(ID)
    }
    fun Insert(data:Colours){
        viewModelScope.launch {
    _CRepository.Insert(data)
   }

    }
    fun Update(data:Colours){
        viewModelScope.launch {
            _CRepository.Update(data)
        }

    }
    fun Delete(data:Colours){
        viewModelScope.launch {
            _CRepository.Delete(data)
        }

    }
}