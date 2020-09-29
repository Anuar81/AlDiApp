package com.example.aldiapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aldiapp.R
import com.example.aldiapp.databinding.HomeFragmentBinding
import com.example.aldiapp.domain.Item
import com.example.aldiapp.ui.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeAdapter.ItemObserver {
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabHome.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
        setupRecycler()

        viewModel.itemList.observe(viewLifecycleOwner, Observer {
            adapter.itemList = it
        })

        viewModel.getAllItems()
    }

    private fun setupRecycler() {
        adapter = HomeAdapter(this)
        binding.recyclerHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerHome.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemListener(item: Item) {
        val bundle = bundleOf(DetailFragment.ARG_ITEM to item)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }
}