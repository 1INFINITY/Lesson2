package ru.mirea.ivashechkinav.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MyTimeDialogFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(activity, this, hour, minute, true)
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            "Выбрано время: $hourOfDay:$minute",
            Snackbar.LENGTH_SHORT
        ).show()
    }
}