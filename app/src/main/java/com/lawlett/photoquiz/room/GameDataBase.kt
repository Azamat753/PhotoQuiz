package com.lawlett.photoquiz.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lawlett.photoquiz.data.Level
import com.lawlett.photoquiz.room.dao.GameDao

@Database(entities = [Level::class],version = 1,exportSchema = false)
abstract class GameDataBase :RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object{
        @Volatile
        private var INSTANCE:GameDataBase?=null

        fun getDatabase(context: Context):GameDataBase{
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    GameDataBase::class.java,
                    "game_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE=instance
                return instance
            }
        }
    }
}