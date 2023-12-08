package com.myapps.pokemon.gui.homefragment.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.myapps.pokemon.data.pokemonsearchmodel.PokemonResponse
import com.myapps.pokemon.databinding.PokemonItemListBinding

class PokemonViewHolder(view:View):ViewHolder(view){
    private val binding = PokemonItemListBinding.bind(view)

    fun render(pokemonResponse: PokemonResponse, onItemClickListener:(Int)->Unit){
        binding.tvPokemonName.text = pokemonResponse.name
        val auxString = pokemonResponse.url.substring(34..pokemonResponse.url.length-2)
        binding.tvId.text = auxString
        val id = auxString.toInt()
        binding.root.setOnClickListener{
            onItemClickListener(id)
        }
    }

}