package com.beva.noteappcomposeui.feature_note.presentation.note

import com.beva.noteappcomposeui.feature_note.domain.model.Note
import com.beva.noteappcomposeui.feature_note.domain.util.NoteOrder
import com.beva.noteappcomposeui.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
