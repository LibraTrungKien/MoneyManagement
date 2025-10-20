package com.example.moneymanagement.presentation.view.loanfragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentLoanBinding
import com.example.moneymanagement.presentation.model.TransactionParent
import com.example.moneymanagement.presentation.view.adapter.LoanParentAdapter
import com.example.moneymanagement.presentation.view.base.BaseFragment

class LoanFragment : BaseFragment<FragmentLoanBinding>(FragmentLoanBinding::inflate) {

    private lateinit var adapter : LoanParentAdapter
    private lateinit var data : List<TransactionParent>
    private lateinit var viewModel : LoanViewModel

    override fun initializeComponent() {

        viewModel = ViewModelProvider(this).get(LoanViewModel::class.java)

        data = viewModel.initData()
        adapter = LoanParentAdapter(data)
        binding.lstHistoryLoan.adapter = adapter
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