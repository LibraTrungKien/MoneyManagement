package com.example.moneymanagement.presentation.view.transactionsactivity

import android.graphics.Color
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.ActivityTransactionsBinding
import com.example.moneymanagement.presentation.Utils
import com.example.moneymanagement.presentation.database.AddNewEntity
import com.example.moneymanagement.presentation.database.AppDatabase
import com.example.moneymanagement.presentation.database.DataManager
import com.example.moneymanagement.presentation.model.TransactionChild
import com.example.moneymanagement.presentation.view.base.BaseActivity
import com.google.gson.Gson
import kotlin.jvm.java

class TransactionsActivity :
    BaseActivity<ActivityTransactionsBinding>(ActivityTransactionsBinding::inflate) {

    private lateinit var data: TransactionChild
    private lateinit var viewModel: TransactionsViewModel
    private lateinit var value : String

    override fun initializeComponent() {
        super.initializeComponent()

        viewModel = ViewModelProvider(this)[TransactionsViewModel::class.java]

        val expendValue = intent.getStringExtra(Utils.ITEM_HISTORY_EXPEND.name)
        val incomeValue  = intent.getStringExtra(Utils.ITEM_HISTORY_INCOME.name)
        val loanValue =  intent.getStringExtra(Utils.ITEM_HISTORY_LOAN.name)

        if (expendValue != null) {
            value = expendValue;
        } else if (incomeValue != null) {
            value = incomeValue;
        } else if (loanValue != null) {
            value = loanValue;
        } else {
            value = "";
        }

        val gson = Gson()
        data = gson.fromJson(value, TransactionChild::class.java)

        val appDatabase = DataManager.getDataBase(this)
        viewModel.setAppDatabase(appDatabase)
    }

    override fun initializeEvents() {
        binding.btnBack.setOnClickListener { finish() }
        binding.btnDelete.setOnClickListener { deleteItem() }
    }

    override fun initializeData() {
        super.initializeData()
    }

    override fun bindView() {
        binding.imgCategoryMain.setImageResource(data.imgCategory)
        binding.txtNameTypeCategory.text = data.nameCategory
        if (data.type == "expend"){
            binding.txtPrice.text = "- " + data.expendPrice.toString() + "vnđ"
            binding.txtPrice.setTextColor(Color.parseColor("#F44336"))
        } else {
            binding.txtPrice.text = "+ " + data.expendPrice.toString() + "vnđ"
            binding.txtPrice.setTextColor(Color.parseColor("#4CAF50"))
        }

        binding.txtdate.text = data.time
        binding.imgCategory.setImageResource(data.imgCategory)
        binding.txtNameCategory.text = data.nameCategory
        binding.txtContentCategory.text = data.note
        binding.txtNameBudget.text = data.nameBudget
        binding.txtContentBudget.text = data.note
        binding.edtNote.setText(data.note)
    }

    private fun deleteItem() {

        val dialog = AlertDialog.Builder(this).setTitle("Delete").setMessage("Do you want to delete this item")
            .setPositiveButton("Delete") { dialog, it ->
                viewModel.delete(data.id)
                finish()
            }
            .setNegativeButton("Cancel") { dialog, it ->
                dialog.dismiss()
            }

            .show()
        dialog.window?.setBackgroundDrawableResource(R.drawable.aleart_dialog_delete)
    }

}