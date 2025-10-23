package com.example.moneymanagement.presentation.view.addnewincome

import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentAddNewIncomeBinding
import com.example.moneymanagement.presentation.model.Category
import com.example.moneymanagement.presentation.view.bottomsheetdialog.BudgetBottomSheet
import com.example.moneymanagement.presentation.view.adapter.AddNewCategoryAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemAddNew
import com.example.moneymanagement.presentation.view.adapter.OnItemClickBottomSheetDialog
import com.example.moneymanagement.presentation.view.base.BaseFragment
import com.example.moneymanagement.presentation.view.bottomsheetdialog.SetDateBottomSheetDialog
import com.example.moneymanagement.presentation.view.bottomsheetdialog.SetTimeBottomSheetDialog

class AddNewIncomeFragment :
    BaseFragment<FragmentAddNewIncomeBinding>(FragmentAddNewIncomeBinding::inflate),
    OnItemClickBottomSheetDialog, OnClickItemAddNew {

    private lateinit var adapter: AddNewCategoryAdapter
    private lateinit var data: List<Category>
    private lateinit var viewModel: AddNewIncomeViewModel


    override fun initializeComponent() {
        viewModel = ViewModelProvider(this)[AddNewIncomeViewModel::class.java]
        data = viewModel.initData()
        adapter = AddNewCategoryAdapter(data, this)
        binding.lstCategory.adapter = adapter
    }

    override fun initializeEvents() {
        binding.btnBudget.setOnClickListener { showBudgetBottomSheet() }
        binding.btnTime.setOnClickListener { setTimeBottomSheet() }
        binding.btnCalender.setOnClickListener { setDateBottomSheet() }
    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

    private fun showBudgetBottomSheet() {
        val bottomSheet = BudgetBottomSheet()
        bottomSheet.setOnButtonClickListener(this)
        bottomSheet.show(requireActivity().supportFragmentManager, "budget Bottom Sheet Dialog")
    }

    private fun setTimeBottomSheet() {
        val bottomSheet = SetTimeBottomSheetDialog()
        bottomSheet.show(requireActivity().supportFragmentManager, "Set Time Bottom Sheet Dialog")
    }

    private fun setDateBottomSheet() {
        val bottomSheet = SetDateBottomSheetDialog()
        bottomSheet.show(requireActivity().supportFragmentManager, "Set Date Bottom Sheet Dialog")
    }

    override fun onClickListener(nameBudget: String) {
        if (nameBudget.isEmpty()) {
            binding.txtBudgetSelection.text = "None"
        } else {
            binding.txtBudgetSelection.text = nameBudget
        }
    }

    override fun onClickListenerCategory(
        item: Category,
        position: Int,
    ) {

    }


}