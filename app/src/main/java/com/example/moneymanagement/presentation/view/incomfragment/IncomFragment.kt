package com.example.moneymanagement.presentation.view.incomfragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentIncomeBinding
import com.example.moneymanagement.presentation.Utils
import com.example.moneymanagement.presentation.database.DataManager
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.view.adapter.IncomeParentAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemTransaction
import com.example.moneymanagement.presentation.view.addnewactivity.AddNewActivity
import com.example.moneymanagement.presentation.view.base.BaseFragment
import com.example.moneymanagement.presentation.view.transactionsactivity.TransactionsActivity
import com.google.gson.Gson

class IncomeFragment : BaseFragment<FragmentIncomeBinding>(FragmentIncomeBinding::inflate),
    OnClickItemTransaction {

    private lateinit var viewModel: IncomeViewModel

    private lateinit var adapter: IncomeParentAdapter

    override fun initializeComponent() {

        viewModel = ViewModelProvider(this)[IncomeViewModel::class.java]

        adapter = IncomeParentAdapter(this, emptyList())
        binding.lstHistoryIncome.adapter = adapter

        val appDatabase = DataManager.getDataBase(requireContext())
        viewModel.setAppDataBase(appDatabase)

        viewModel.incomeList.observe(viewLifecycleOwner) { incomeEntities ->
            val filteredType = incomeEntities.filter { it.type == "income" }
            val parentData = viewModel.initData(filteredType)
           adapter.setData(parentData)
        }
    }

    override fun initializeEvents() {
        binding.btnAddInCome.setOnClickListener { addIncome() }
    }

    override fun initializeData() {
    }

    override fun bindView() {
        super.bindView()
    }

    private fun addIncome() {
        val intent = Intent(requireContext(), AddNewActivity::class.java)
        startActivity(intent)
    }

    override fun onItemClick(item: TransactionChild) {
        val gson = Gson()
        val value = gson.toJson(item)
        val intent = Intent(requireContext(), TransactionsActivity::class.java)
        intent.putExtra(Utils.ITEM_HISTORY_INCOME.name, value)
        startActivity(intent)
    }

}