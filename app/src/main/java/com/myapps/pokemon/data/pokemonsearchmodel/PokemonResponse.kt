package com.myapps.pokemon.data.pokemonsearchmodel

import com.google.gson.annotations.SerializedName


data class PokemonResponse(
 @SerializedName("name") val name:String,
 @SerializedName("url") val url:String)
