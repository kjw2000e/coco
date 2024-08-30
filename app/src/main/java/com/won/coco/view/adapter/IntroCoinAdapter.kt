package com.won.coco.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.won.coco.R
import com.won.coco.databinding.IntroCoinItemBinding
import com.won.coco.model.CurrentPriceItemResult
import timber.log.Timber

class IntroCoinAdapter: ListAdapter<CurrentPriceItemResult, IntroCoinAdapter.FavoriteCoinViewHolder>(diffUtil) {

    private var itemClickListener: ((CurrentPriceItemResult) -> Unit) ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.intro_coin_item, parent, false)
        val binding = IntroCoinItemBinding.bind(view)

        return FavoriteCoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteCoinViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setOnItemClickListener(listener: ((CurrentPriceItemResult) -> Unit)?) {
        itemClickListener = listener
    }

    override fun getItemCount(): Int {
        Timber.e("getItemCount : ${super.getItemCount()}")
        return super.getItemCount()
    }

    inner class FavoriteCoinViewHolder(private val binding: IntroCoinItemBinding): ViewHolder(binding.root) {
        fun bind(item: CurrentPriceItemResult) {
            binding.coinName.text = item.coinName

            binding.root.setOnClickListener {
                itemClickListener?.let { it(item) }
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<CurrentPriceItemResult>() {
            override fun areItemsTheSame(
                oldItem: CurrentPriceItemResult,
                newItem: CurrentPriceItemResult
            ): Boolean {
                return oldItem.coinName == newItem.coinName
            }

            override fun areContentsTheSame(
                oldItem: CurrentPriceItemResult,
                newItem: CurrentPriceItemResult
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    interface OnIntroCoinItemClickListener {
        fun onItemClick(item: CurrentPriceItemResult)
    }
}