package com.example.moneymanagement.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanagement.databinding.ItemBudgetBinding
import com.example.moneymanagement.presentation.model.BudgetDetailModel

class BudgetDetailAdapter(
    val data : List<BudgetDetailModel>
) : RecyclerView.Adapter<BudgetDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBudgetBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class ViewHolder(val binding : ItemBudgetBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindView(budgetDetail : BudgetDetailModel){
            binding.imgBudget.setBackgroundResource(budgetDetail.imgBudget)
            binding.txtNameBudget.text = budgetDetail.nameBudget
            binding.txtMoney.text = budgetDetail.moneyBudget.toString()
        }

    }
}