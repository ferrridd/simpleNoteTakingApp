package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_view.view.*


class NoteAdapter(
     val notes:MutableList<Note>
) :RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    inner class NoteViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val noteTitle:TextView = itemView.findViewById(R.id.textViewNote)
        val deleteButton:Button = itemView.findViewById(R.id.buttonDelete)
        init {
            deleteButton.setOnClickListener{v:View ->
                val position : Int = adapterPosition
                deleteANote(position)
            }
        }
    }

    fun addNote(note: Note){
        this.notes.add(note)
        notifyItemInserted(notes.size-1)
    }

    fun deleteANote(position: Int){

        notes.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.itemView.apply {
            textViewNote.text = currentNote.title
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}