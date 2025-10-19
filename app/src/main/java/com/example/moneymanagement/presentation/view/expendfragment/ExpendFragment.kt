package com.example.moneymanagement.presentation.view.expendfragment

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.moneymanagement.databinding.ActivityAddNewBinding
import com.example.moneymanagement.databinding.FragmentExpendBinding
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.model.TransactionParent
import com.example.moneymanagement.presentation.view.Utils
import com.example.moneymanagement.presentation.view.adapter.ExpendParentAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemTransaction
import com.example.moneymanagement.presentation.view.addnew.AddNewActivity
import com.example.moneymanagement.presentation.view.base.BaseFragment

class ExpendFragment : BaseFragment<FragmentExpendBinding>(FragmentExpendBinding::inflate) {

    private val viewModel: ExpandViewModel by viewModels()

    private lateinit var parentAdapter: ExpendParentAdapter

    private lateinit var data : List<TransactionParent>

    override fun initializeComponent() {

        val onItemClick = object : OnClickItemTransaction {
            override fun onItemClick(item: TransactionChild) {
                Toast.makeText(requireContext(), item.expendPrice.toString(), Toast.LENGTH_LONG).show()
            }
        }

        data = viewModel.initData()
        parentAdapter = ExpendParentAdapter(onItemClick, data)
        binding.lstHistoryExpendParent.adapter = parentAdapter
    }

    override fun initializeEvents() {
        binding.btnAddExpand.setOnClickListener {
            addExpend()
        }
    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        super.bindView()
    }

    private fun addExpend(){
        val key = Utils.ADD_EXPENSE.name
        val intent = Intent(requireContext(), AddNewActivity::class.java)
        startActivity(intent)
    }


}