package com.example.codingchallenge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.codingchallenge.domain.AnimeCharacter
import com.example.codingchallenge.databinding.ItemLayoutBinding

class MyAdapter : ListAdapter<AnimeCharacter,MyAdapter.MyViewHolder>(AnimeDiffUtil){
    inner class MyViewHolder(private val binding: ItemLayoutBinding): ViewHolder(binding.root){
        fun onBind(animeCharacter: AnimeCharacter){
            binding.textViewCharacter.text = animeCharacter.characterName
            binding.textViewAnime.text = animeCharacter.animeName
            binding.textViewQuote.text = animeCharacter.characterQuote
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(animeCharacter = currentList[position])
    }
}

object AnimeDiffUtil : DiffUtil.ItemCallback<AnimeCharacter>(){
    override fun areItemsTheSame(oldItem: AnimeCharacter, newItem: AnimeCharacter): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: AnimeCharacter, newItem: AnimeCharacter): Boolean {
        return oldItem == newItem
    }
}