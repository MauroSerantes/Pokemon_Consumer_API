package com.myapps.pokemon.data.network

import com.myapps.pokemon.data.pokemoninfomodel.Pokemon
import com.myapps.pokemon.data.pokemonsearchmodel.PokemonListResponse
import com.myapps.pokemon.utils.ServiceConstants.POKEMON_END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService{
    @GET(POKEMON_END_POINT)
    suspend fun getPokemonsList():Response<PokemonListResponse>

    @GET("$POKEMON_END_POINT/")
    suspend fun getPokemonListByOffset(
        @Query("offset") offset:Int,
        @Query("limit") limit:Int
    ):Response<PokemonListResponse>

    @GET("$POKEMON_END_POINT/{id}/")
    suspend fun getPokemonInformationById(@Path("id") id:Int):Response<Pokemon>
}