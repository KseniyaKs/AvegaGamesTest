package com.example.avegagamestest.presentation.eventslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.avegagamestest.R
import com.example.avegagamestest.databinding.FragmentEventsListBinding
import com.example.avegagamestest.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val MSK_LOCATION = "msk"

@AndroidEntryPoint
class EventsListFragment : Fragment(R.layout.fragment_events_list) {

    private val viewModel: EventsListViewModel by viewModels()
    private val binding: FragmentEventsListBinding by viewBinding()
    private val adapter by lazy { EventsListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeViewModel()
    }

    private fun initViews() {
        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            adapter.setOnClickListener(object : EventsListAdapter.OnItemClickListener {
                override fun onItemClick(item: EventViewHolder?) {
                    findNavController().navigate(EventsListFragmentDirections.actionListEventsToEvent("123123"))
                }
            })
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.newPager(MSK_LOCATION).collect {
                adapter.submitData(it)
            }
        }
    }
}