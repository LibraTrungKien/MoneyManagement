package com.example.moneymanagement.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanagement.R
import com.example.moneymanagement.databinding.ItemAddNewCategoryBinding
import com.example.moneymanagement.presentation.model.Category

class AddNewCategoryAdapter(
    val data: List<Category>,
    val onClickListener: OnClickItemCategory
) : RecyclerView.Adapter<AddNewCategoryAdapter.ViewHolder>() {

    private var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAddNewCategoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(data[position])

        holder.binding.imgCategory.isSelected = (position == selectedPosition)

    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val binding: ItemAddNewCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.imgCategory.setOnClickListener {
                if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                    val position = selectedPosition
                    selectedPosition = absoluteAdapterPosition
                    notifyItemChanged(position)
                    notifyItemChanged(selectedPosition)

                    onClickListener.onClickListener(data[absoluteAdapterPosition], absoluteAdapterPosition)
                }
            }
        }

        fun bindView(category: Category) {
            binding.imgCategory.setImageResource(category.imgTypeCategory)
            binding.txtNameTypeCategory.text = category.typeCategory
        }
    }
}