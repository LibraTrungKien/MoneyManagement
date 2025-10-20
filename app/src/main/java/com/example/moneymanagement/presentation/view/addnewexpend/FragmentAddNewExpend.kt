package com.example.moneymanagement.presentation.view.addnewexpend

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentAddNewExpendBinding
import com.example.moneymanagement.presentation.model.Category
import com.example.moneymanagement.presentation.view.BudgetBottomSheet
import com.example.moneymanagement.presentation.view.adapter.AddNewCategoryAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemCategory
import com.example.moneymanagement.presentation.view.base.BaseFragment
import kotlin.getValue

class FragmentAddNewExpend :
    BaseFragment<FragmentAddNewExpendBinding>(FragmentAddNewExpendBinding::inflate) {

    private lateinit var adapter: AddNewCategoryAdapter
    private lateinit var data: List<Category>
    private lateinit var viewModel: AddNewExpendViewModel

    private val onClickListener = object : OnClickItemCategory {
        override fun onClickListener(item: Category, position: Int) {
        }
    }

    override fun initializeComponent() {
        viewModel = ViewModelProvider(this).get(AddNewExpendViewModel::class.java)
        data = viewModel.initData()
        adapter = AddNewCategoryAdapter(data, onClickListener)
        binding.lstCategory.adapter = adapter
    }

    override fun initializeEvents() {
        binding.btnBudget.setOnClickListener {
            showBudgetBottomSheet()
        }
    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

    private fun showBudgetBottomSheet() {
        val bottomSheet = BudgetBottomSheet()
        bottomSheet.show(requireActivity().supportFragmentManager, "budget Bottom Sheet Dialog")
    }

}