package com.myapps.pokemon.gui.homefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapps.pokemon.R
import com.myapps.pokemon.data.pokemonsearchmodel.PokemonResponse


class PokemonAdapter(private var list:List<PokemonResponse> = emptyList(),
    private val onItemClickListener:(Int)->Unit):RecyclerView.Adapter<PokemonViewHolder>(){

    fun updateList(list: List<PokemonResponse>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item_list,parent,false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.render(list[position],onItemClickListener)
    }
}