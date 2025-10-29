package com.example.moneymanagement.presentation.view.loanfragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentLoanBinding
import com.example.moneymanagement.presentation.database.DataManager
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent
import com.example.moneymanagement.presentation.view.adapter.LoanParentAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemTransaction
import com.example.moneymanagement.presentation.view.addnewactivity.AddNewActivity
import com.example.moneymanagement.presentation.view.base.BaseFragment

class LoanFragment : BaseFragment<FragmentLoanBinding>(FragmentLoanBinding::inflate),
    OnClickItemTransaction {

    private lateinit var adapter: LoanParentAdapter
    private lateinit var data: List<TransactionParent>
    private lateinit var viewModel: LoanViewModel

    override fun initializeComponent() {

        viewModel = ViewModelProvider(this)[LoanViewModel::class.java]

        val appDatabase = DataManager.getDataBase(requireContext())
        viewModel.setAppDatabase(appDatabase)

        adapter = LoanParentAdapter(emptyList(), this)
        binding.lstHistoryLoan.adapter = adapter

        viewModel.loanList.observe(viewLifecycleOwner){ loanEntities ->
            val filterType = loanEntities.filter { it.type == "loan" }
            data = viewModel.initData(filterType)
            adapter.setData(data)
        }

    }

    override fun initializeEvents() {
        binding.btnAddLoan.setOnClickListener {
            val intent = Intent(requireContext(), AddNewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

    override fun onItemClick(item: TransactionChild) {
        TODO("Not yet implemented")
    }


}