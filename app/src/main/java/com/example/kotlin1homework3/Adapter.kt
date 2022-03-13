package com.example.kotlin1homework3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1homework3.databinding.ItemListBinding

class Adapter(private val list: MutableList<String>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var onClick: OnClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setOnClick(onClick: OnClick){
        this.onClick = onClick
    }

    inner class ViewHolder(private var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.ivImage.loadImage(image)
            itemView.setOnClickListener {
                if (binding.background.visibility == View.GONE) {
                    binding.background.visibility = View.VISIBLE
                    onClick.onClicked(image)
                } else {
                    binding.background.visibility = View.GONE
                    onClick.onRemoved(image)
                }
            }
        }
    }

    interface OnClick {
        fun onClicked(position: String)
        fun onRemoved(position: String)
    }}
