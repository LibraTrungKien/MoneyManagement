package com.example.moneymanagement.presentation.view.bottomsheetdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moneymanagement.databinding.BottomSheetSetTimeBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SetTimeBottomSheetDialog : BottomSheetDialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = BottomSheetSetTimeBinding.inflate(inflater, container, false)
        return binding.root
    }

}