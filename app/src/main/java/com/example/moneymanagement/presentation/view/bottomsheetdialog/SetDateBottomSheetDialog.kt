package com.example.moneymanagement.presentation.view.bottomsheetdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moneymanagement.databinding.BottomSheetSetDateBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SetDateBottomSheetDialog : BottomSheetDialogFragment() {

    private var binding: BottomSheetSetDateBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.numberPickerYear.setFormatter{
            String.format("%02d", it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  BottomSheetSetDateBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}