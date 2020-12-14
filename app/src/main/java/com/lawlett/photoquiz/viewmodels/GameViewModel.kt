package com.lawlett.photoquiz.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lawlett.photoquiz.data.Level
import com.lawlett.photoquiz.repositories.GameRepositories
import com.lawlett.photoquiz.room.GameDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val repositories: GameRepositories

    init {
        val gameDao = GameDataBase.getDatabase(application).gameDao()
        repositories = GameRepositories(gameDao)
    }
    fun addLevel(level: Level) {
        viewModelScope.launch(Dispatchers.IO) {
            repositories.addTask(level)
        }
    }


    fun getLevel(level:Int): LiveData<List<Level>> = repositories.loadLevel(level)

}