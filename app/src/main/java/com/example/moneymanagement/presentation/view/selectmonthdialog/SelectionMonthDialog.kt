package com.example.moneymanagement.presentation.view.popup

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.moneymanagement.databinding.DialogSelectMonthBinding
import com.example.moneymanagement.presentation.model.MonthModel
import com.example.moneymanagement.presentation.view.adapter.MonthAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemMonth
import com.example.moneymanagement.presentation.view.selectmonthdialog.SelectionMonthViewModel
import java.util.Calendar

class SelectionYearPopup(
    private val context: Context,
    private val owner: ViewModelStoreOwner,
) : PopupWindow(
    ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.WRAP_CONTENT
), OnClickItemMonth {

    private val binding: DialogSelectMonthBinding =
        DialogSelectMonthBinding.inflate(LayoutInflater.from(context))

    private var calendar = Calendar.getInstance()
    private var calendarYear = calendar.get(Calendar.YEAR)
    private var adapter: MonthAdapter
    private var viewModel: SelectionMonthViewModel
    private var data: List<MonthModel>

    init {
        contentView = binding.root
        isFocusable = true
        isOutsideTouchable = true
        elevation = 10f
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        viewModel =
            ViewModelProvider(owner)[SelectionMonthViewModel::class.java]
        data = viewModel.initData()

        adapter = MonthAdapter(data, this)
        binding.lstMonth.adapter = adapter

        binding.txtYear.text = calendarYear.toString()

        binding.btnRight.setOnClickListener {
            calendarYear++
            binding.txtYear.text = calendarYear.toString()
        }

        binding.btnLeft.setOnClickListener {
            calendarYear--
            binding.txtYear.text = calendarYear.toString()
        }

        binding.btnSave.setOnClickListener {
            dismiss()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    fun showPopup(view: View) {
        showAsDropDown(view, 0, -50);
    }

    override fun onClickListenerCategory(item: MonthModel, position: Int) {}


}
