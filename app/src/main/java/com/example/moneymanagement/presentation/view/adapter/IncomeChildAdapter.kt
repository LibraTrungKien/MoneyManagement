package com.example.moneymanagement.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanagement.databinding.ItemHistoryExpendChildBinding
import com.example.moneymanagement.databinding.ItemHistoryIncomeChildBinding
import com.example.moneymanagement.presentation.model.TransactionChild

class IncomeChildAdapter(
    private val onItemClick : OnClickItemTransaction,
    private val data: List<TransactionChild>) :
    RecyclerView.Adapter<IncomeChildAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryIncomeChildBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val binding: ItemHistoryIncomeChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(itemChild: TransactionChild) {
            binding.imgCategory.setImageResource(itemChild.imgCategory)
            binding.txtCategory.text = itemChild.nameCategory
            binding.txtTime.text = itemChild.time.toString()
            binding.txtContentCategory.text = itemChild.note
            binding.txtPrice.text = itemChild.expendPrice.toString() + "vnđ"

            binding.root.setOnClickListener {
                onItemClick.onItemClick(itemChild)
            }
        }

    }
}