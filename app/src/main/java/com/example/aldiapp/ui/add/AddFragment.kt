package com.example.aldiapp.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.aldiapp.R
import com.example.aldiapp.databinding.AddFragmentBinding
import com.example.aldiapp.domain.Item
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_fragment.*

@AndroidEntryPoint
class AddFragment : Fragment() {
    private var _binding: AddFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAppBar()

        binding.btnAppSave.setOnClickListener {
            if (isAllCompleted()) {
                saveData()
            }
        }

        viewModel.addSuccecsLivedata.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_addFragment_to_homeFragment)
            }
        })
    }

    private fun setAppBar() {
        activity?.let {
            it.title = getString(R.string.add_fragment_title)
        }
    }

    override fun onDetach() {
        super.onDetach()
        activity?.let {
            it.title = getString(R.string.app_name)
        }
    }

    private fun isAllCompleted() : Boolean {
        return viewModel.isAllCompleted(
            binding.txtAppName, binding.txtAppUser, binding.txtAppPass, getString(R.string.add_fragment_error_text)
        )
    }

    private fun saveData() {
        viewModel.addItem(
            Item(
                txt_app_name.text.toString(),
                txt_app_user.text.toString(),
                txt_app_pass.text.toString()
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}