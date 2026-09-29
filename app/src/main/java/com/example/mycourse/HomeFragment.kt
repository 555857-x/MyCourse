package com.example.mycourse

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLihatMateri: AppCompatButton =
            view.findViewById(R.id.btnLihatMateri)

        btnLihatMateri.setOnClickListener {
            (requireActivity() as MainActivity).bukaHalaman(1)
        }
    }
}