package com.example.sqlite_kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlite_kotlin.databinding.ActivityAddnoteBinding

class addnoteActivity: AppCompatActivity(){
    private lateinit var binding: ActivityAddnoteBinding
    private lateinit var db: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddnoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        //funcion que ejecuta una opcion al dar click en el boton guardar
        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0, title, content)

            db.insertNote(note)
            finish()
            Toast.makeText(this, "Nota Guardada", Toast.LENGTH_SHORT).show()
        }
    }
}