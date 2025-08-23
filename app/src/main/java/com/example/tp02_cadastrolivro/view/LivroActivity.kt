package com.example.tp02_cadastrolivro.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp02_cadastrolivro.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LivroActivity : AppCompatActivity(R.layout.activity_livro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvNomeLivro = findViewById<TextView>(R.id.txvNomeLivro)
        val txvAutorLivro = findViewById<TextView>(R.id.txvAutorLivro)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fabVolta)

        txvNomeLivro.text = intent.getStringExtra("nomeLivro").toString()
        txvAutorLivro.text = intent.getStringExtra("autorLivro").toString()

        fabVolta.setOnClickListener {
            finish()
        }
    }
}