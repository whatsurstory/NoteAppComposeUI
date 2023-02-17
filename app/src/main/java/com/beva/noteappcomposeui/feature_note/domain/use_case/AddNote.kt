package com.beva.noteappcomposeui.feature_note.domain.use_case

import com.beva.noteappcomposeui.feature_note.domain.model.InvalidNoteException
import com.beva.noteappcomposeui.feature_note.domain.model.Note
import com.beva.noteappcomposeui.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank() ) {
            throw InvalidNoteException("The Title of Note Can't Be Empty.")
        }
        if (note.content.isBlank() ) {
            throw InvalidNoteException("The Content of Note Can't Be Empty.")
        }
        repository.insertNote(note)
    }
}