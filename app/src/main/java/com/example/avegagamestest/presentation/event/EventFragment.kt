package com.example.avegagamestest.presentation.event

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.avegagamestest.R
import com.example.avegagamestest.databinding.FragmentEventBinding
import com.example.avegagamestest.databinding.FragmentEventsListBinding
import com.example.avegagamestest.presentation.eventslist.EventsListViewModel
import com.example.avegagamestest.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventFragment : Fragment(R.layout.fragment_event) {

    private val viewModel: EventViewModel by viewModels()
    private val binding: FragmentEventBinding by viewBinding()
    private val args: EventFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getEventDetail(args.eventId)

        initViews()
        observeViewModel()
    }

    private fun initViews() {
        with(binding){

        }
    }

    private fun observeViewModel() {
        observe(viewModel.eventDetails) {

        }
    }

}