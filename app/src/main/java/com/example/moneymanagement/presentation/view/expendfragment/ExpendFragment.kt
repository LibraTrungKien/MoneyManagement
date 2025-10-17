package com.example.moneymanagement.presentation.view.expendfragment

import androidx.fragment.app.viewModels
import com.example.moneymanagement.databinding.FragmentExpendBinding
import com.example.moneymanagement.presentation.model.ExpendParent
import com.example.moneymanagement.presentation.view.adapter.ExpendParentAdapter
import com.example.moneymanagement.presentation.view.base.BaseFragment

class ExpendFragment : BaseFragment<FragmentExpendBinding>(FragmentExpendBinding::inflate) {

    private val viewModel: ExpandViewModel by viewModels()

    private lateinit var parentAdapter: ExpendParentAdapter

    private lateinit var data : List<ExpendParent>

    override fun initializeComponent() {

        data = viewModel.initData()
        parentAdapter = ExpendParentAdapter(data)
        binding.lstHistoryExpendParent.adapter = parentAdapter
    }


}