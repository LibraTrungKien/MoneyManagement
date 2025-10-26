package com.example.moneymanagement.presentation.view.expendfragment

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentExpendBinding
import com.example.moneymanagement.presentation.dataexpend.DataManager
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.view.Utils
import com.example.moneymanagement.presentation.view.adapter.ExpendParentAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemTransaction
import com.example.moneymanagement.presentation.view.addnew.AddNewActivity
import com.example.moneymanagement.presentation.view.base.BaseFragment

class ExpendFragment : BaseFragment<FragmentExpendBinding>(FragmentExpendBinding::inflate), OnClickItemTransaction {

    private lateinit var viewModel: ExpendViewModel

    private lateinit var parentAdapter: ExpendParentAdapter

    override fun initializeComponent() {

        viewModel = ViewModelProvider(this)[ExpendViewModel::class.java]

        parentAdapter = ExpendParentAdapter(this, emptyList())
        binding.lstHistoryExpendParent.adapter = parentAdapter

        val appDatabase = DataManager.getDataBase(requireContext())
        viewModel.setAppDataBase(appDatabase)

        viewModel.expendList.observe(viewLifecycleOwner) { expendEntities ->
            val parentData = viewModel.initData(expendEntities)
            parentAdapter.setData(parentData)
        }
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

    override fun onItemClick(item: TransactionChild) {
        Toast.makeText(requireContext(), item.nameCategory, Toast.LENGTH_SHORT).show()
    }


}