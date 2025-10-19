package com.example.moneymanagement.presentation.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moneymanagement.presentation.view.addnewexpend.FragmentAddNewExpend
import com.example.moneymanagement.presentation.view.addnewincome.AddNewIncomeFragment
import com.example.moneymanagement.presentation.view.addnewloan.AddNewLoanFragment

class AddNewAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> FragmentAddNewExpend()
            1 -> AddNewIncomeFragment()
            2 -> AddNewLoanFragment()
            else -> FragmentAddNewExpend()
        }
    }

    override fun getItemCount(): Int = 3
}