package com.example.moneymanagement.presentation.view.expendstaticfragment

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.FragmentExpendStaticBinding
import com.example.moneymanagement.presentation.database.AppDatabase
import com.example.moneymanagement.presentation.database.DataManager
import com.example.moneymanagement.presentation.view.base.BaseFragment
import com.example.moneymanagement.presentation.view.expendfragment.ExpendViewModel
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF

class ExpendStaticFragment :
    BaseFragment<FragmentExpendStaticBinding>(FragmentExpendStaticBinding::inflate) {

    private lateinit var viewModel: ExpendStaticViewModel

    override fun initializeComponent() {
        super.initializeComponent()

        val appDatabase = DataManager.getDataBase(requireContext())

        viewModel = ViewModelProvider(this)[ExpendStaticViewModel::class.java]
        viewModel.setAppDataBase(appDatabase, this)

        viewModel.pieChartData.observe(viewLifecycleOwner) {
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

        val dataSet = PieDataSet(entries, "" )
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


}