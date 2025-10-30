package com.example.sqlite_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlite_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: NotesDatabaseHelper
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)
        notesAdapter= NotesAdapter(db.getAllNotes(), this)

        binding.notesRecicyView.layoutManager = LinearLayoutManager(this)
        binding.notesRecicyView.adapter = notesAdapter

        //redirigue al usuario a la pantalla para agregar una nueva nota
        binding.addButton.setOnClickListener {
            val intent = Intent(this, addnoteActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onResume() {
        super.onResume()
        notesAdapter.refreshData(db.getAllNotes())
    }
}