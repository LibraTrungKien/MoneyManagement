package com.example.moneymanagement.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moneymanagement.databinding.ButtonSheetBudgetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BudgetBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ButtonSheetBudgetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ButtonSheetBudgetBinding.inflate(inflater, container, false)
        return binding.root
    }


}