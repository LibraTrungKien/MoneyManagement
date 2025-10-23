package com.example.moneymanagement.presentation.view.addnewexpend

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentAddNewExpendBinding
import com.example.moneymanagement.presentation.dataexpend.DataManager
import com.example.moneymanagement.presentation.model.Category
import com.example.moneymanagement.presentation.view.bottomsheetdialog.BudgetBottomSheet
import com.example.moneymanagement.presentation.view.adapter.AddNewCategoryAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemAddNew
import com.example.moneymanagement.presentation.view.adapter.OnItemClickBottomSheetDialog
import com.example.moneymanagement.presentation.view.base.BaseFragment
import com.example.moneymanagement.presentation.view.bottomsheetdialog.SetDateBottomSheetDialog
import com.example.moneymanagement.presentation.view.bottomsheetdialog.SetTimeBottomSheetDialog

class FragmentAddNewExpend :
    BaseFragment<FragmentAddNewExpendBinding>(FragmentAddNewExpendBinding::inflate),
    OnItemClickBottomSheetDialog, OnClickItemAddNew {

    private lateinit var adapter: AddNewCategoryAdapter
    private lateinit var data: List<Category>
    private lateinit var viewModel: AddNewExpendViewModel
    private var nameBudget: String? = null

    override fun initializeComponent() {
        viewModel = ViewModelProvider(this)[AddNewExpendViewModel::class.java]

        val db = DataManager.getDataBase(requireContext())

        viewModel.setAppDataBase(db)

        data = viewModel.initData()
        adapter = AddNewCategoryAdapter(data, this)
        binding.lstCategory.adapter = adapter
    }

    override fun initializeEvents() {
        binding.btnBudget.setOnClickListener {
            showBudgetBottomSheet()
        }
    }

    override fun initializeData() {
        binding.btnBudget.setOnClickListener { showBudgetBottomSheet() }
        binding.btnTime.setOnClickListener { setTimeBottomSheet() }
        binding.btnCalender.setOnClickListener { setDateBottomSheet() }
    }

    override fun bindView() {
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
            binding.txtBudgetSelection.text = nameBudget
            this.nameBudget = nameBudget
    }

    fun insertExpendEntity() {
        val amountMoney = getAmountMoney()
        val note = getNote()
        viewModel.insertExpendEntity(
            amountMoney,
            "",
            0,
            nameBudget!!,
            0,
            note!!,
            "",
            5L
        )
    }

    private fun getAmountMoney(): Int {
        val text = binding.edtSetMoney.text.toString().trim()
        val amount = text.toIntOrNull()

        if (amount == null || amount <= 0) {
            Toast.makeText(requireContext(), "Please enter a valid amount", Toast.LENGTH_SHORT)
                .show()
            return 0
        } else {
            return amount
        }
    }

    private fun getNote(): String? {
        val note = binding.edtNote.text.toString()
        return note
    }

    override fun onClickListenerCategory(
        item: Category,
        position: Int,
    ) {
        Toast.makeText(requireContext(), item.typeCategory, Toast.LENGTH_SHORT).show()
    }

}