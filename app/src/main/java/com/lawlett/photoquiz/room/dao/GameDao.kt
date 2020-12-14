package com.lawlett.photoquiz.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lawlett.photoquiz.data.Level

@Dao
interface GameDao {
    @Query("SELECT * FROM game_table WHERE id=:level ")
    fun loadLevel(level: Int): LiveData<List<Level>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLevel(level:Level)
}
