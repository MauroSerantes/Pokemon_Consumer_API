package com.myapps.pokemon.gui.homefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapps.pokemon.data.pokemonsearchmodel.PokemonListResponse
import com.myapps.pokemon.data.PokemonRepository
import com.myapps.pokemon.utils.DataStatus
import kotlinx.coroutines.launch


class PokemonHomeFragmentViewModel:ViewModel(){

    private val repository = PokemonRepository()

    private val _pokemonResponse = MutableLiveData<DataStatus<PokemonListResponse>>()
    val pokemonResponse:LiveData<DataStatus<PokemonListResponse>> get() = _pokemonResponse


    fun fetchPokemons() = viewModelScope.launch{
        repository.fetchPokemonData().collect{
            _pokemonResponse.value = it
        }
    }

    fun fetchPokemonsByOffset(offset:Int) = viewModelScope.launch {
        repository.fetchPokemonByOffset(offset).collect{
            _pokemonResponse.value = it
        }
    }
}