package com.example.colorapp.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
 abstract class ColorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun Add(data:Colours)
    @Delete
    abstract suspend fun Delete(data:Colours)
    @Update
    abstract suspend fun Update(data: Colours)
    @Query("Select * From 'Color'")
     abstract fun GetAllData(): Flow<List<Colours>>
    @Query("Select * From 'Color' where id=:id")
    abstract fun GetDataById(id:Long): Flow<Colours>

}