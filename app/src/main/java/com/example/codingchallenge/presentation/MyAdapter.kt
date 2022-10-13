package com.example.codingchallenge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.codingchallenge.domain.Quote
import com.example.codingchallenge.databinding.ItemLayoutBinding

class MyAdapter : ListAdapter<Quote,MyAdapter.MyViewHolder>(AnimeDiffUtil){
    inner class MyViewHolder(private val binding: ItemLayoutBinding): ViewHolder(binding.root){

        fun onBind(quote: Quote){
            binding.textViewExtraData.text = quote.extraData
            binding.textViewQuoteAuthor.text = quote.name
            binding.textViewQuote.text = quote.quote
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(quote = currentList[position])
    }
}

object AnimeDiffUtil : DiffUtil.ItemCallback<Quote>(){
    override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
        return oldItem == newItem
    }
}