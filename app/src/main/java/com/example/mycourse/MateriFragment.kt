package com.example.mycourse

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class MateriFragment : Fragment(R.layout.fragment_materi) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val daftarMateri = listOf(
            R.id.btnMateri1 to "Layout dan View Binding",
            R.id.btnMateri2 to "Intent dan Activity",
            R.id.btnMateri3 to "Spinner, Date dan Time Picker",
            R.id.btnMateri4 to "Dialog pada Android",
            R.id.btnMateri5 to "Options Menu dan TabLayout"
        )

        daftarMateri.forEach { (buttonId, namaMateri) ->
            val button: AppCompatButton = view.findViewById(buttonId)

            button.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Materi: $namaMateri",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}