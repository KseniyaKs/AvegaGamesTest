package com.example.avegagamestest.presentation.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.avegagamestest.R
import com.example.avegagamestest.databinding.ItemDateListBinding
import com.example.avegagamestest.presentation.model.event.EventDateModel


class DateAdapter(
    private var datesList: List<String> = emptyList()
) : PagingDataAdapter<EventDateModel, DateViewHolder>(DateDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        return DateViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_date_list, parent, false),
        )
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(datesList[position])
    }

    override fun getItemCount(): Int = datesList.size

    fun setData(datesList: List<String>) {
        this.datesList = datesList
        notifyDataSetChanged()
    }
}

class DateViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding(ItemDateListBinding::bind)

    fun bind(date: String?) {
        binding.textViewDate.text = date
    }
}

private object DateDiffItemCallback : DiffUtil.ItemCallback<EventDateModel>() {

    override fun areItemsTheSame(oldItem: EventDateModel, newItem: EventDateModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: EventDateModel, newItem: EventDateModel): Boolean {
        return oldItem.startTime == newItem.startTime
    }
}