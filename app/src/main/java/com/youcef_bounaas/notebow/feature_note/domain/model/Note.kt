package com.youcef_bounaas.notebow.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.youcef_bounaas.notebow.ui.theme.BabyBlue
import com.youcef_bounaas.notebow.ui.theme.LightBlue
import com.youcef_bounaas.notebow.ui.theme.LightGreen
import com.youcef_bounaas.notebow.ui.theme.RedOrange
import com.youcef_bounaas.notebow.ui.theme.RedPink
import com.youcef_bounaas.notebow.ui.theme.Violet


@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)
