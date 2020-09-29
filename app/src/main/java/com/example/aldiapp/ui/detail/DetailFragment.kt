package com.example.aldiapp.ui.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.aldiapp.R
import com.example.aldiapp.databinding.DetailFragmentBinding
import com.example.aldiapp.domain.Item

class DetailFragment : Fragment() {
    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()

    companion object {
        val ARG_ITEM = "item arguments"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewModel.item = it.getSerializable(ARG_ITEM) as Item
        }

        setViewItem()

        binding.btnDetailEdit.setOnClickListener {
            viewModel.isEditable = !viewModel.isEditable
            setEditable()
        }

    }

    private fun setViewItem() {
        viewModel.item?.let {
            binding.txtDetailName.setText(it.title)
            binding.txtDetailUser.setText(it.userName)
            binding.txtDetailPass.setText(it.password)
        }
    }

    private fun setEditable() {
        if (viewModel.isEditable) {
            binding.txlDetailUser.isEnabled = true
            binding.txlDetailPass.isEnabled = true
            binding.btnDetailEdit.text = getString(R.string.detail_fragment_btn_save)
        }else {
            binding.txlDetailUser.isEnabled = false
            binding.txlDetailPass.isEnabled = false
            binding.btnDetailEdit.text = getString(R.string.detail_fragment_btn_edit)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}