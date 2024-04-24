package com.youcef_bounaas.notebow.di

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.youcef_bounaas.notebow.feature_note.data.data_source.NoteDatabase
import com.youcef_bounaas.notebow.feature_note.data.repository.NoteRepositoryImpl
import com.youcef_bounaas.notebow.feature_note.domain.repository.NoteRepository
import com.youcef_bounaas.notebow.feature_note.domain.use_case.AddNote
import com.youcef_bounaas.notebow.feature_note.domain.use_case.DeleteNote
import com.youcef_bounaas.notebow.feature_note.domain.use_case.GetNote
import com.youcef_bounaas.notebow.feature_note.domain.use_case.GetNotes
import com.youcef_bounaas.notebow.feature_note.domain.use_case.NoteUseCases
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
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db : NoteDatabase) : NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}