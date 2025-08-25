package com.example.tp02_cadastrolivro.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp02_cadastrolivro.R
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.tp02_cadastrolivro.model.Livro
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNomeLivro = findViewById<EditText>(R.id.edtNomeLivro)
        val edtAutorLivro = findViewById<EditText>(R.id.edtAutorLivro)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fabAvanca)

        var livro = Livro("Sem Livro", "Sem Autor")

        btnCadastrar.setOnClickListener {
            val nome = edtNomeLivro.text.toString()
            val autor = edtAutorLivro.text.toString()

            livro = Livro(nome, autor)

            alertaSucesso()
            edtNomeLivro.text.clear()
            edtAutorLivro.text.clear()
            edtNomeLivro.requestFocus()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, LivroActivity::class.java)
            intent.putExtra("nomeLivro", livro.nomeLivro)
            intent.putExtra("autorLivro", livro.autorLivro)
            startActivity(intent)
        }
    }
    fun alertaSucesso() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sucesso")
        builder.setMessage("Livro cadastrado!")
        var alert = builder.create()
        alert.show()
    }
}