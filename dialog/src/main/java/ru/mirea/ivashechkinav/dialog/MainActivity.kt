package ru.mirea.ivashechkinav.dialog

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnShowDialogFragment).setOnClickListener(this::onClickShowDialog)
        findViewById<Button>(R.id.btnShowTimeDialog).setOnClickListener(this::onClickShowTimeDialog)
        findViewById<Button>(R.id.btnShowDateDialog).setOnClickListener(this::onClickShowDateDialog)
        findViewById<Button>(R.id.btnShowProgressDialog).setOnClickListener(this::onClickShowProgressDialog)
    }

    private fun onClickShowDialog(view: View) {
        val dialogFragment = MyDialogFragment()
        dialogFragment.show(supportFragmentManager, "mirea")
    }

    private fun onClickShowTimeDialog(view: View) {
        val dialogFragment = MyTimeDialogFragment()
        dialogFragment.show(supportFragmentManager, "mirea")
    }

    private fun onClickShowDateDialog(view: View) {
        val dialogFragment = MyDateDialogFragment()
        dialogFragment.show(supportFragmentManager, "mirea")
    }

    private fun onClickShowProgressDialog(view: View) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Downloading...")
        progressDialog.setCancelable(true)
        progressDialog.setOnCancelListener {
            Snackbar.make(
                findViewById(android.R.id.content),
                "Загрузка прервана",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        progressDialog.show()
        GlobalScope.launch {
            delay(2000)
            if (progressDialog.isShowing) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Загрузка завершена",
                    Snackbar.LENGTH_SHORT
                ).show()
                progressDialog.dismiss()
            }
        }
    }

    fun onOkClicked() {
        Toast.makeText(
            applicationContext, "Вы выбрали кнопку \"Иду дальше\"!",
            Toast.LENGTH_LONG
        ).show()
    }

    fun onCancelClicked() {
        Toast.makeText(
            applicationContext, "Вы выбрали кнопку \"Нет\"!",
            Toast.LENGTH_LONG
        ).show()
    }

    fun onNeutralClicked() {
        Toast.makeText(
            applicationContext, "Вы выбрали кнопку \"На паузе\"!",
            Toast.LENGTH_LONG
        ).show()
    }
}