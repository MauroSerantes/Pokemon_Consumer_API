package com.myapps.pokemon.data.pokemoninfomodel

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("base_experience") val baseExperience:Int,
    @SerializedName("height")val height:Int,
    @SerializedName("order") val order:Int,
    @SerializedName("weight") val weight:Int,
    @SerializedName("sprites") val sprites: PokemonSprites,
    @SerializedName("stats") val stats:List<PokemonStats>,
    @SerializedName("types") val types:List<PokemonTypes>,
)


data class PokemonSprites(
    @SerializedName("other") val other: PokemonOtherSprites,
)

data class PokemonOtherSprites(@SerializedName("official-artwork") val offArtwork: PokemonOfficialArtwork)
data class PokemonOfficialArtwork(@SerializedName("front_default") val frontDefault:String)


data class PokemonStats(@SerializedName("base_stat") val baseStat:Int,@SerializedName("stat") val stat:Stat)
data class Stat(@SerializedName("name") val name:String)

data class PokemonTypes(
    @SerializedName("type") val type: Type
)
data class Type(@SerializedName("name") val name:String)
