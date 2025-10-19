package com.example.moneymanagement.presentation.view.incomfragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.moneymanagement.databinding.FragmentIncomeBinding
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent
import com.example.moneymanagement.presentation.view.adapter.IncomeParentAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemTransaction
import com.example.moneymanagement.presentation.view.base.BaseFragment
import kotlin.getValue

class IncomeFragment : BaseFragment<FragmentIncomeBinding>(FragmentIncomeBinding::inflate) {

    private val viewModel: IncomeViewModel by viewModels()

    private lateinit var adapter: IncomeParentAdapter

    private lateinit var data: List<TransactionParent>

    override fun initializeComponent() {

        val onItemClick = object : OnClickItemTransaction {
            override fun onItemClick(item: TransactionChild) {
                Toast.makeText(requireContext(), item.nameCategory, Toast.LENGTH_LONG).show()
            }

        }

        data = viewModel.initData()
        adapter = IncomeParentAdapter(onItemClick, data)
        binding.lstHistoryIncome.adapter = adapter
    }

    override fun initializeEvents() {
        super.initializeEvents()
    }

    override fun initializeData() {
    }

    override fun bindView() {
        super.bindView()
    }

}