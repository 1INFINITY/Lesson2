package ru.mirea.ivashechkinav.intentfilter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var buttonOpenWeb: Button
    lateinit var buttonOpenApp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOpenWeb = findViewById(R.id.btnOpenWeb)
        buttonOpenApp = findViewById(R.id.btnOpenApp)

        buttonOpenWeb.setOnClickListener {
            val address: Uri = Uri.parse("https://www.mirea.ru/")
            val openLinkIntent = Intent(Intent.ACTION_VIEW, address)
            startActivity(openLinkIntent)
        }

        buttonOpenApp.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Мои данные ФИО")
            startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"))
        }
    }
}