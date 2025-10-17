package com.example.moneymanagement.presentation.view.expendfragment

import androidx.lifecycle.ViewModel
import com.example.moneymanagement.R
import com.example.moneymanagement.presentation.model.ExpendChild
import com.example.moneymanagement.presentation.model.ExpendParent

class ExpandViewModel() : ViewModel() {

    private val parentData = mutableListOf<ExpendParent>()

        fun initData(): List<ExpendParent> {

            val aprilTransactions = listOf(
                ExpendChild(
                    imgCategory = R.drawable.ic_hmburger,
                    nameCategory = "Ăn uống",
                    contentCategory = "Bữa tối",
                    time = System.currentTimeMillis() - 1000000,
                    expendPrice = 8000
                ),

                ExpendChild(
                    imgCategory = R.drawable.ic_hmburger,
                    nameCategory = "Ăn uống",
                    contentCategory = "Bữa sáng",
                    time = System.currentTimeMillis() - 1000000,
                    expendPrice = 8000
                ),

                ExpendChild(
                    imgCategory = R.drawable.ic_hmburger,
                    nameCategory = "Ăn uống",
                    contentCategory = "Ăn lẩu",
                    time = System.currentTimeMillis() - 1000000,
                    expendPrice = 800000
                ),
            )

            parentData.add(
                ExpendParent(
                    date = "Apr 2025",
                    childExpend = aprilTransactions
                )
            )
            parentData.add(ExpendParent("Apr 2024", aprilTransactions))

            return parentData
        }


}