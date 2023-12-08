package com.myapps.pokemon.gui.informationfragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapps.pokemon.R
import com.myapps.pokemon.data.pokemoninfomodel.PokemonTypes
import com.myapps.pokemon.data.pokemonsearchmodel.PokemonResponse


class PokemonTypesAdapter(private var list:List<PokemonTypes> = emptyList()):RecyclerView.Adapter<PokemonTypesViewHolder>(){


    fun updateList(list: List<PokemonTypes>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PokemonTypesViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return PokemonTypesViewHolder(inflater.inflate(R.layout.pokemon_item_types,parent,false),parent.context)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PokemonTypesViewHolder, position: Int) {
        holder.render(list[position])
    }
}