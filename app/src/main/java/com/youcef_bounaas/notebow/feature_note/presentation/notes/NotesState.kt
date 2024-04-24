package com.youcef_bounaas.notebow.feature_note.presentation.notes

import com.youcef_bounaas.notebow.feature_note.domain.model.Note
import com.youcef_bounaas.notebow.feature_note.domain.use_case.GetNotes
import com.youcef_bounaas.notebow.feature_note.domain.util.NoteOrder
import com.youcef_bounaas.notebow.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
