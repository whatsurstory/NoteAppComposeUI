package com.beva.noteappcomposeui.di

import android.app.Application
import androidx.room.Room
import com.beva.noteappcomposeui.feature_note.data.data_source.NoteDataBase
import com.beva.noteappcomposeui.feature_note.data.repository.NoteRepositoryImpl
import com.beva.noteappcomposeui.feature_note.domain.repository.NoteRepository
import com.beva.noteappcomposeui.feature_note.domain.use_case.AddNote
import com.beva.noteappcomposeui.feature_note.domain.use_case.DeleteNote
import com.beva.noteappcomposeui.feature_note.domain.use_case.GetNotes
import com.beva.noteappcomposeui.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBase(app: Application): NoteDataBase{
        return  Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDataBase) : NoteRepository {
        return NoteRepositoryImpl(database.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}