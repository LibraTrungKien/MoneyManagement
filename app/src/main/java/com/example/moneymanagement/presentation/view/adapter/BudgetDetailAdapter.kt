package com.example.moneymanagement.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanagement.databinding.ItemBudgetBinding
import com.example.moneymanagement.presentation.database.BudgetEntity

class BudgetDetailAdapter(
    private var items: List<BudgetEntity>,
    private var onClickUpdateMoney: OnClickListenerUpdateMoney
) : RecyclerView.Adapter<BudgetDetailAdapter.ViewHolder>() {

    fun setData(newItems: List<BudgetEntity>) {
        this.items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBudgetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: ItemBudgetBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(budgetDetail: BudgetEntity) {
            binding.txtNameBudget.text = budgetDetail.nameBudget
            binding.txtMoney.text = budgetDetail.moneyBudget.toString()

            val moneyJar = binding.txtMoney.text.toString()
            val nameJar = binding.txtNameBudget.text.toString()

            binding.btnUpdateMoney.setOnClickListener {
                onClickUpdateMoney.getJar(absoluteAdapterPosition + 1, moneyJar.toInt(), nameJar)

            }

            binding.root.setOnClickListener {
                onClickUpdateMoney.onItemClick(budgetDetail)
            }

        }

    }
}
