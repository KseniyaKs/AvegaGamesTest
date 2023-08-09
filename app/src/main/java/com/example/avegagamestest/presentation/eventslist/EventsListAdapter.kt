package com.example.avegagamestest.presentation.eventslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.avegagamestest.R
import com.example.avegagamestest.databinding.ItemEventsListBinding
import com.example.avegagamestest.presentation.model.eventslist.EventItemModel

class EventsListAdapter : PagingDataAdapter<EventItemModel, EventViewHolder>(EventDiffItemCallback) {

    private var onClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_events_list, parent, false),
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onClickListener?.onItemClick(holder)
        }
    }

    fun setOnClickListener(onClickListener: OnItemClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(item: EventViewHolder?)
    }
}

class EventViewHolder(
    private val view: View,
) : RecyclerView.ViewHolder(view) {

    private val binding by viewBinding(ItemEventsListBinding::bind)

    fun bind(event: EventItemModel?) {
        with(binding) {
            Glide.with(view.context)
                .load(event?.image)
                .transform(CenterCrop(), RoundedCorners(30))
                .placeholder(R.drawable.item_placeholder)
                .into(imageViewImage)

            textViewTitle.text = event?.title
        }
    }
}

private object EventDiffItemCallback : DiffUtil.ItemCallback<EventItemModel>() {

    override fun areItemsTheSame(oldItem: EventItemModel, newItem: EventItemModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: EventItemModel, newItem: EventItemModel): Boolean {
        return oldItem.id == newItem.id
    }
}