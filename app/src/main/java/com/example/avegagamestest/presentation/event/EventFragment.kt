package com.example.avegagamestest.presentation.event

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.avegagamestest.R
import com.example.avegagamestest.databinding.FragmentEventBinding
import com.example.avegagamestest.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventFragment : Fragment(R.layout.fragment_event) {

    private val viewModel: EventViewModel by viewModels()
    private val binding: FragmentEventBinding by viewBinding()
    private val args: EventFragmentArgs by navArgs()
    private val imageViewPagerAdapter by lazy { ImageViewPagerAdapter() }
    private val dateAdapter by lazy { DateAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getEventDetail(args.eventId)
        initViews()
        observeViewModel()
    }

    private fun initViews() {
        with(binding) {
            viewPagerImage.adapter = imageViewPagerAdapter
            viewPagerImage.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            recyclerView.adapter = dateAdapter

            toolbar.imageViewBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun observeViewModel() {
        binding.progressBar.visibility = View.VISIBLE
        observe(viewModel.eventDetails) {
            binding.progressBar.visibility = View.GONE
            imageViewPagerAdapter.setData(it.images.map { model -> model.image })
            dateAdapter.setData(it.dates.map { date -> date.startTime })

            with(binding) {
                viewPagerImage.visibility = View.VISIBLE
                textViewAvailableDate.visibility = View.VISIBLE
                toolbar.textViewTitle.text = it.title
                textViewDescription.text = it.description
                textViewFullDescription.text = it.fullDescription
            }
        }
    }
}