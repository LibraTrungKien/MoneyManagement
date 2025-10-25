package com.example.moneymanagement.presentation.view.bottomsheetdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.BottomSheetBudgetBinding
import com.example.moneymanagement.presentation.view.adapter.OnClickItemAddNew
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BudgetBottomSheet : BottomSheetDialogFragment() {

    private var binding: BottomSheetBudgetBinding? = null

    private lateinit var listener: OnClickItemAddNew

    private var selectionBudget: String = "None"


    fun setOnButtonClickListener(listener: OnClickItemAddNew) {
        this.listener = listener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnNone?.setOnClickListener {
            selectionBudget = "None"
            it.setBackgroundResource(R.drawable.bg_budget_selection)
        }
        binding?.btnNecessities?.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_budget_selection)
            selectionBudget = "Necessities"
        }

        binding?.btnEducation?.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_budget_selection)
            selectionBudget = "Education"
        }

        binding?.btnSaving?.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_budget_selection)
            selectionBudget = "Saving"
        }
        binding?.btnPlay?.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_budget_selection)
            selectionBudget = "Play"
        }
        binding?.btnInvestment?.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_budget_selection)
            selectionBudget = "Investment"
        }
        binding?.btnGive?.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_budget_selection)
            selectionBudget = "Give"
        }
        binding?.btnCancel?.setOnClickListener { dismiss() }

        binding?.btnSave?.setOnClickListener {
            listener.onClickListenerBudget(selectionBudget)
            dismiss()
        }

        binding!!.btnCancel.setOnClickListener { dismiss() }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetBudgetBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}