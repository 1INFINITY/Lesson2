package ru.mirea.ivashechkinav.dialog

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Здравствуй МИРЭА!")
            .setMessage("Успех близок?")
            .setIcon(R.mipmap.sym_def_app_icon)
            .setPositiveButton(
                "Иду дальше"
            ) { dialog, _ ->
                (activity as MainActivity).onOkClicked()
                dialog?.cancel()
            }
            .setNeutralButton(
                "На паузе"
            ) { dialog, _ ->
                (activity as MainActivity).onNeutralClicked()
                dialog?.cancel()
            }
            .setNegativeButton(
                "Нет"
            ) { dialog, _ ->
                (activity as MainActivity).onCancelClicked()
                dialog?.cancel()
            }
        return builder.create()
    }
}