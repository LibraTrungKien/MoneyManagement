package com.example.moneymanagement.presentation.view.addnewincome

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.databinding.FragmentAddNewIncomeBinding
import com.example.moneymanagement.presentation.dataexpend.DataManager
import com.example.moneymanagement.presentation.model.Category
import com.example.moneymanagement.presentation.view.bottomsheetdialog.BudgetBottomSheet
import com.example.moneymanagement.presentation.view.adapter.AddNewCategoryAdapter
import com.example.moneymanagement.presentation.view.adapter.OnClickItemAddNew
import com.example.moneymanagement.presentation.view.addnewexpend.AddNewExpendViewModel
import com.example.moneymanagement.presentation.view.base.BaseFragment
import com.example.moneymanagement.presentation.view.bottomsheetdialog.SetDateBottomSheetDialog
import com.example.moneymanagement.presentation.view.bottomsheetdialog.SetTimeBottomSheetDialog
import java.util.Calendar

class AddNewIncomeFragment :
    BaseFragment<FragmentAddNewIncomeBinding>(FragmentAddNewIncomeBinding::inflate),
    OnClickItemAddNew {

    private lateinit var adapter: AddNewCategoryAdapter
    private lateinit var data: List<Category>
    private lateinit var viewModel: AddNewIncomeViewModel
    private var nameBudget: String? = null
    private var calendar = Calendar.getInstance()


    override fun initializeComponent() {
        viewModel = ViewModelProvider(this)[AddNewIncomeViewModel::class.java]

        val db = DataManager.getDataBase(requireContext())

//        viewModel.setAppDataBase(db)

        data = viewModel.initData()
        adapter = AddNewCategoryAdapter(data, this)
        binding.lstCategory.adapter = adapter
    }

    override fun initializeEvents() {
        binding.btnBudget.setOnClickListener {
            showBudgetBottomSheet()
        }
    }

    override fun initializeData() {
        binding.btnBudget.setOnClickListener { showBudgetBottomSheet() }
        binding.btnTime.setOnClickListener { setTimeBottomSheet() }
        binding.btnCalender.setOnClickListener { setDateBottomSheet() }
    }

    override fun bindView() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        binding.txtTime.text = "$hour:$minute"
        binding.txtDate.text = "$day/$month/$year"
    }

    private fun showBudgetBottomSheet() {
        val bottomSheet = BudgetBottomSheet()
        bottomSheet.setOnButtonClickListener(this)
        bottomSheet.show(requireActivity().supportFragmentManager, "budget Bottom Sheet Dialog")
    }

    private fun setTimeBottomSheet() {
        val bottomSheet = SetTimeBottomSheetDialog()
        bottomSheet.setOnButtonClickListener(this)
        bottomSheet.show(requireActivity().supportFragmentManager, "Set Time Bottom Sheet Dialog")
    }

    private fun setDateBottomSheet() {
        val bottomSheet = SetDateBottomSheetDialog()
        bottomSheet.setOnButtonClickListener(this)
        bottomSheet.show(requireActivity().supportFragmentManager, "Set Date Bottom Sheet Dialog")
    }

    override fun onClickListenerBudget(nameBudget: String) {
        binding.txtBudgetSelection.text = nameBudget
        this.nameBudget = nameBudget
    }

    override fun onCLickListenerDate(
        day: Int,
        month: Int,
        year: Int
    ) {
        val date = "$day/$month/$year"
        binding.txtDate.text = date
    }

    override fun onClickListerTime(minute: Int, hour: Int) {
        val time = "$hour:$minute"
        binding.txtTime.text = time
    }

    override fun onClickListenerCategory(
        item: Category,
        position: Int,
    ) {
        Toast.makeText(requireContext(), item.typeCategory, Toast.LENGTH_SHORT).show()
    }


}