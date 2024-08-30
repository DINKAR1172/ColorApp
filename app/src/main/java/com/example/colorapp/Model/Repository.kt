package com.example.colorapp.Model

import androidx.room.Update
import kotlinx.coroutines.flow.Flow

class Repository(private  val dao: ColorDao) {
    suspend fun Insert(data:Colours){
        dao.Add(data)
    }
    suspend fun Update(data: Colours){
        dao.Update(data)
    }
    suspend fun Delete(data: Colours){
        dao.Delete(data)
    }
     fun GetAllData():Flow<List<Colours>>{
        return dao.GetAllData()
    }
    fun GetDataById(Id:Long):Flow<Colours>{
        return dao.GetDataById(Id)
    }
}