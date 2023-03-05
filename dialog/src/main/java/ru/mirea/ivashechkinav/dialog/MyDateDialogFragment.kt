package ru.mirea.ivashechkinav.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MyDateDialogFragment: DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)
        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(requireContext(), this, year, month, day)
    }
    override fun onDateSet(p0: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            "Выбрана дата: $dayOfMonth.${month + 1}.$year",
            Snackbar.LENGTH_SHORT
        ).show()
    }
}