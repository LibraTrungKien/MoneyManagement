package com.example.moneymanagement.presentation.view.loanfragment

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentLoanBinding
import com.example.moneymanagement.presentation.Utils
import com.example.moneymanagement.presentation.database.DataManager
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent
import com.example.moneymanagement.presentation.view.adapter.LoanParentAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemTransaction
import com.example.moneymanagement.presentation.view.addnewactivity.AddNewActivity
import com.example.moneymanagement.presentation.view.base.BaseFragment
import com.example.moneymanagement.presentation.view.transactionsactivity.TransactionsActivity
import com.google.gson.Gson

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

            binding.txtTransaction.visibility = if (filterType.isEmpty()) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

    }

    override fun initializeEvents() {
        binding.btnAddLoan.setOnClickListener {
            val intent = Intent(requireContext(), AddNewActivity::class.java)
            startActivity(intent)
        }

        binding.edtSearch.setOnEditorActionListener { textView, actionId, event ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH ||
                actionId == android.view.inputmethod.EditorInfo.IME_ACTION_DONE
            ) {
                searchHistory()
                true
            } else {
                false
            }
        }


    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

    override fun onItemClick(item: TransactionChild, date : String) {
        val gson = Gson()
        val value = gson.toJson(item)
        val intent = Intent(requireContext(), TransactionsActivity::class.java)
        intent.putExtra(Utils.ITEM_HISTORY_LOAN.name, value)
        intent.putExtra("KEY_LOAN", date)
        startActivity(intent)
    }

    private fun searchHistory() {
        val search = binding.edtSearch.text.toString()
        if (search.isEmpty()) {
            viewModel.loanList.observe(viewLifecycleOwner) { loanEntities ->
                val filteredType = loanEntities.filter { it.type == "loan" }
                val parentData = viewModel.initData(filteredType)
                adapter.setData(parentData)
            }
        } else {
            viewModel.loanList.observe(viewLifecycleOwner) { loanEntities ->
                val filteredType = loanEntities.filter {
                    it.type == "loan" && it.nameTypeCategory.contains(search)
                }
                val parentData = viewModel.initData(filteredType)
                adapter.setData(parentData)
            }
        }
    }

}