package com.example.moneymanagement.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanagement.databinding.ItemHistoryExpendChildBinding
import com.example.moneymanagement.presentation.model.ExpendChild

class ExpendChildAdapter(private val data: List<ExpendChild>) :
    RecyclerView.Adapter<ExpendChildAdapter.ExpendChildViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpendChildViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryExpendChildBinding.inflate(inflater, parent, false)
        return ExpendChildViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ExpendChildViewHolder, position: Int
    ) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class ExpendChildViewHolder(val binding: ItemHistoryExpendChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(itemChild: ExpendChild) {
            binding.imgCategory.setImageResource(itemChild.imgCategory)
            binding.txtCategory.text = itemChild.nameCategory
            binding.txtTime.text = itemChild.time.toString()
            binding.txtContentCategory.text = itemChild.contentCategory
            binding.txtPrice.text = itemChild.expendPrice.toString() + "vnđ"
        }

    }

}