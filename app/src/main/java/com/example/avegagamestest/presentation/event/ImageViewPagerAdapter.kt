package com.example.avegagamestest.presentation.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.avegagamestest.R
import com.example.avegagamestest.databinding.ItemPagerImageBinding

class ImageViewPagerAdapter(
    private var urlsList: List<String> = emptyList()
) : RecyclerView.Adapter<ImageViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(private val binding: ItemPagerImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {
            Glide.with(binding.root.context)
                .load(imageUrl)
                .error(R.drawable.img_placeholder)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imageViewImage)
        }
    }

    override fun getItemCount(): Int = urlsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ItemPagerImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(urlsList[position])
    }

    fun setData(urlsList: List<String>) {
        this.urlsList = urlsList
        notifyDataSetChanged()
    }
}
