package com.example.moneymanagement.presentation.view.addnewloan

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentAddNewLoanBinding
import com.example.moneymanagement.databinding.FragmentLoanBinding
import com.example.moneymanagement.presentation.model.Category
import com.example.moneymanagement.presentation.view.adapter.AddNewCategoryAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemCategory
import com.example.moneymanagement.presentation.view.addnewincome.AddNewIncomeViewModel
import com.example.moneymanagement.presentation.view.base.BaseFragment
import kotlin.getValue

class AddNewLoanFragment : BaseFragment<FragmentAddNewLoanBinding>(FragmentAddNewLoanBinding::inflate) {

    private lateinit var adapter: AddNewCategoryAdapter
    private lateinit var data: List<Category>
    private lateinit var viewModel: AddNewLoanViewModel


    private val onClickListener = object : OnClickItemCategory {
        override fun onClickListener(
            item: Category,
            position: Int
        ) {
        }


    }

    override fun initializeComponent() {
        viewModel = ViewModelProvider(this).get(AddNewLoanViewModel::class.java)
        data = viewModel.initData()
        adapter = AddNewCategoryAdapter(data, onClickListener)
        binding.lstCategory.adapter = adapter
    }

    override fun initializeEvents() {
        super.initializeEvents()
    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

}