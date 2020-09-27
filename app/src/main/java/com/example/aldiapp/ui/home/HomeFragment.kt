package com.example.aldiapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aldiapp.R
import com.example.aldiapp.databinding.HomeFragmentBinding
import com.example.aldiapp.domain.Item
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
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
        adapter = HomeAdapter()
        binding.recyclerHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerHome.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}