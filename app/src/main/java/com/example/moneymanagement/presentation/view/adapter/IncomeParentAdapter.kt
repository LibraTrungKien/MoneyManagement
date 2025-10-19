package com.example.moneymanagement.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanagement.databinding.ItemHistoryIncomeParentBinding
import com.example.moneymanagement.presentation.model.TransactionParent

class IncomeParentAdapter(
    private val onClickListner: OnClickItemTransaction,
    private val data: List<TransactionParent>) :
    RecyclerView.Adapter<IncomeParentAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryIncomeParentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class ViewHolder(val binding: ItemHistoryIncomeParentBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindView(itemParent: TransactionParent) {
            binding.txtDateParent.text = itemParent.date

            val parentAdapter = IncomeChildAdapter(onClickListner, itemParent.child )
            binding.listHistoryIncomeChild.adapter = parentAdapter

            binding.listHistoryIncomeChild.setRecycledViewPool(viewPool)


        }
    }
}