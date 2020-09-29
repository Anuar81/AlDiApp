package com.example.aldiapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aldiapp.R
import com.example.aldiapp.databinding.ItemHomeBinding
import com.example.aldiapp.domain.Item

class HomeAdapter(private val listener: ItemObserver) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var itemList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener {
            listener.itemListener(itemList[position])
        }
    }

    override fun getItemCount(): Int = itemList.size

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemHomeBinding.bind(itemView)

        fun bind(item: Item) = with(binding) {
            recyclerItemTitle.text = item.title
        }
    }

    interface ItemObserver {
        fun itemListener(item: Item)
    }
}