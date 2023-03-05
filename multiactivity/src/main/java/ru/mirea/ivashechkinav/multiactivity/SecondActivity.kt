package ru.mirea.ivashechkinav.multiactivity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    lateinit var textSent: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val text: String = intent.getStringExtra("key")!!
        textSent = findViewById(R.id.textViewSent)
        textSent.text = text


    }
}