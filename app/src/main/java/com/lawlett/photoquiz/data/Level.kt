package com.lawlett.photoquiz.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_table")
data class Level(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var firstImg: String? = null,
    var secondImg: String? = null,
    var thirdImg: String? = null,
    var fourImg: String? = null,
    var answer: String? = null,

    )