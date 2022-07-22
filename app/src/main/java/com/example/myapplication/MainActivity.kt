package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_view.*

class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter:NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdapter = NoteAdapter(mutableListOf())


        recyclerViewNotes.adapter = noteAdapter

        recyclerViewNotes.layoutManager = LinearLayoutManager(this)

        buttonAddNote.setOnClickListener{
            val noteTitle = editTextNotes.text.toString()
            if(noteTitle.isNotEmpty()){
                val note = Note(noteTitle,noteAdapter.notes.size)
                noteAdapter.addNote(note)
                editTextNotes.text.clear()
            }
        }

//        buttonDelete.setOnClickListener{
//            noteAdapter.deleteANote()
//        }
    }
}