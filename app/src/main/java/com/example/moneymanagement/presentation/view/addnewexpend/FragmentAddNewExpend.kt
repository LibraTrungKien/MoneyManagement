package com.example.moneymanagement.presentation.view.addnewexpend

import androidx.fragment.app.viewModels
import com.example.moneymanagement.databinding.FragmentAddNewExpendBinding
import com.example.moneymanagement.presentation.model.Category
import com.example.moneymanagement.presentation.view.adapter.AddNewExpendAdapter
import com.example.moneymanagement.presentation.view.base.BaseFragment
import kotlin.getValue

class FragmentAddNewExpend :
    BaseFragment<FragmentAddNewExpendBinding>(FragmentAddNewExpendBinding::inflate) {

    private lateinit var adapter: AddNewExpendAdapter
    private lateinit var data: List<Category>
    private val viewModel: AddNewExpendViewModel by viewModels()

    override fun initializeComponent() {

        data = viewModel.initData()
        adapter = AddNewExpendAdapter(data)
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