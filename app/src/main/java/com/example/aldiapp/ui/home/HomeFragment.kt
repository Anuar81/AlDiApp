package com.example.aldiapp.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aldiapp.R
import com.example.aldiapp.databinding.ActivityMainBinding
import com.example.aldiapp.databinding.HomeFragmentBinding
import com.example.aldiapp.domain.Item
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val item1 = getCorrectItem("facebook", "usuario", "password")
        val item2 = getCorrectItem("twitter", "usuario2", "password2")

        viewModel.addItem(item1)
        viewModel.addItem(item2)


        viewModel.itemList.observe(viewLifecycleOwner, Observer {
            it.forEach{
                println(it.title)
            }
        } )

        viewModel.getAllItems()

    }


    private fun getCorrectItem(title: String, user: String, pass: String) : Item {
        return Item(title = title, userName = user, password = pass)
    }
}