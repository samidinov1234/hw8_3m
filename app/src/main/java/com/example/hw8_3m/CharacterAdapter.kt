package com.example.hw8_3m

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.hw8_3m.databinding.ItemCharacterBinding

class CharacterAdapter(
    private var rickList: ArrayList<CharacterModel>,
    val onClick: (model: CharacterModel) -> Unit
) : Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(rickList[position])
    }

    override fun getItemCount(): Int {
        return rickList.size
    }

    inner class ViewHolder(private var binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterModel) {
            binding.tvRick.text = item.name
            binding.tvAlive.text = item.info
            Glide.with(binding.imgCharacter).load(item.image).into(binding.imgCharacter)

            itemView.setOnClickListener {
                onClick.invoke(item)
            }

        }
    }
}


