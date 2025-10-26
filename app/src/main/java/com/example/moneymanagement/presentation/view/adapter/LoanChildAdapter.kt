package com.example.moneymanagement.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanagement.databinding.ItemHistoryLoanChildBinding
import com.example.moneymanagement.presentation.model.TransactionChild

class LoanChildAdapter(val data: List<TransactionChild>): RecyclerView.Adapter<LoanChildAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryLoanChildBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class ViewHolder(val binding : ItemHistoryLoanChildBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindView(itemChild: TransactionChild) {
            binding.imgCategory.setImageResource(itemChild.imgCategory)
            binding.txtCategory.text = itemChild.nameCategory
            binding.txtTime.text = itemChild.time
            binding.txtContentCategory.text = itemChild.note
            binding.txtPrice.text = itemChild.expendPrice.toString() + "vnđ"
        }


    }

}