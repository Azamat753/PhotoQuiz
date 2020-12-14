package com.lawlett.photoquiz.repositories

import androidx.lifecycle.LiveData
import com.lawlett.photoquiz.data.Level
import com.lawlett.photoquiz.room.dao.GameDao

class GameRepositories(private val gameDao: GameDao) {
    fun loadLevel(level: Int): LiveData<List<Level>> {
        return gameDao.loadLevel(level)
    }
    suspend fun addTask(level: Level) {
        gameDao.addLevel(level)
    }
}