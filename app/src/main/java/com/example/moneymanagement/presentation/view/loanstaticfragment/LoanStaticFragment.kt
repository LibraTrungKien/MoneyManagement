package com.example.moneymanagement.presentation.view.loanstaticfragment

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentLoanStaticBinding
import com.example.moneymanagement.presentation.database.DataManager
import com.example.moneymanagement.presentation.view.base.BaseFragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class LoanStaticFragment : BaseFragment<FragmentLoanStaticBinding>(FragmentLoanStaticBinding::inflate) {

    private lateinit var viewModle : LoanStaticViewModel

    override fun initializeComponent() {
        super.initializeComponent()

        viewModle = ViewModelProvider(this)[LoanStaticViewModel::class.java]
        val appDataBase = DataManager.getDataBase(requireContext())

        viewModle.setAppDataBase(appDataBase, this)

        viewModle.pieChartData.observe(viewLifecycleOwner){
            updatePieChart(it)
        }

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

    private fun updatePieChart(entries: List<PieEntry>) {
        val pieChart: PieChart = binding.pieChart

        binding.pieChart.setUsePercentValues(true)

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        dataSet.valueTextSize = 14f
        dataSet.valueTextColor = Color.WHITE
        pieChart.description.isEnabled = false
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = false // chú thích màu
        pieChart.isRotationEnabled = false // tăt bật xoay

        pieChart.setTransparentCircleAlpha(0)

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(pieChart))

        pieChart.data = data
        pieChart.invalidate()
    }


    // hàm main(){} là hàm thực thực hện chương trình

}