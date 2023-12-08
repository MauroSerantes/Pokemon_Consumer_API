package com.myapps.pokemon.gui.informationfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapps.pokemon.data.PokemonRepository
import com.myapps.pokemon.data.pokemoninfomodel.Pokemon
import com.myapps.pokemon.data.pokemonsearchmodel.PokemonListResponse
import com.myapps.pokemon.utils.DataStatus
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PokemonInformationViewModel:ViewModel() {

    private val repository = PokemonRepository()

    private val _pokemonInfo = MutableLiveData<DataStatus<Pokemon>>()
    val pokemonInfo: LiveData<DataStatus<Pokemon>> get() = _pokemonInfo


    fun fetchPokemonInformation(id:Int) = viewModelScope.launch{
        repository.fetchPokemonInformationById(id).collect{
            _pokemonInfo.value = it
        }
    }

}