package com.example.moneymanagement.presentation.view.expendstaticfragment

import android.graphics.Color
import androidx.core.content.ContextCompat
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.FragmentExpendStaticBinding
import com.example.moneymanagement.presentation.view.base.BaseFragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF

class ExpendStaticFragment : BaseFragment<FragmentExpendStaticBinding>(FragmentExpendStaticBinding::inflate)  {

    override fun initializeComponent() {
        super.initializeComponent()
        setupPieChart()
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


    private fun setupPieChart() {
        val pieChart: PieChart = binding.pieChart

        val entries = getPieChartData()
        val dataSet = PieDataSet(entries, "Chi tiêu")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        dataSet.valueTextSize = 14f
        dataSet.valueTextColor = Color.WHITE

        val data = PieData(dataSet)
        dataSet.setDrawIcons(true)
        dataSet.iconsOffset = MPPointF(0f, 60f)

        pieChart.data = data
        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.setCenterTextSize(8f)
        pieChart.setTransparentCircleAlpha(0) // set độ loang lổ giữa vong tron
        pieChart.holeRadius = 45f
        pieChart.setHoleColor(Color.WHITE)
        pieChart.isRotationEnabled = false // cho hoặc k cho người dùng xoay biểu đồ

        pieChart.legend.isEnabled = false // chú thích đỏ, xanh...
        pieChart.description.isEnabled = false // ẩn tên mô tả
        data.setValueFormatter(PercentFormatter(pieChart)); // thêm %

        pieChart.invalidate()
    }

    private fun getPieChartData(): ArrayList<PieEntry> {
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(45.2f, "Ăn uống", ContextCompat.getDrawable(requireContext(), R.drawable.ic_car)))
        entries.add(PieEntry(48.2f, "Di chuyển", ContextCompat.getDrawable(requireContext(), R.drawable.ic_car)))
        entries.add(PieEntry(20f, "Giải trí"))
        entries.add(PieEntry(10f, "Khác"))
        return entries
    }

}