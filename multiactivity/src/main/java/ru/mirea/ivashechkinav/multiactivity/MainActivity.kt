package ru.mirea.ivashechkinav.multiactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var inputText: EditText
    lateinit var buttonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputText = findViewById(R.id.editTextForSend)
        buttonSend = findViewById(R.id.btnSend)

        buttonSend.setOnClickListener{
            onClickNewActivity()
        }
    }
    private fun onClickNewActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        val textSend = inputText.text.toString()
        intent.putExtra("key", textSend)
        startActivity(intent)
    }
}