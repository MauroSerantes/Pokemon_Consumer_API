package com.myapps.pokemon.data

import com.myapps.pokemon.core.RetrofitHelper
import com.myapps.pokemon.data.network.PokemonApiService
import com.myapps.pokemon.utils.DataStatus
import com.myapps.pokemon.utils.ServiceConstants.POKEMON_LIMIT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class PokemonRepository {
    private val retrofit = RetrofitHelper

    suspend fun fetchPokemonData() = flow {
        emit(DataStatus.loading())
        val result = retrofit.getRetrofitService().getPokemonsList()
        when(result.code()){
            200->{emit(DataStatus.success(result.body()))}
            400->{emit(DataStatus.error(result.message()))}
            500->{emit(DataStatus.error(result.message()))}
        }
    }.catch {
        emit(DataStatus.error(it.message.toString()))
    }.flowOn(Dispatchers.IO)


    suspend fun fetchPokemonByOffset(offset:Int) = flow{
        emit(DataStatus.loading())
        val result = retrofit.getRetrofitService().getPokemonListByOffset(offset,
        POKEMON_LIMIT)
        when(result.code()){
            200->{emit(DataStatus.success(result.body()))}
            400->{emit(DataStatus.error(result.message()))}
            500->{emit(DataStatus.error(result.message()))}
        }
    }.catch{
        emit(DataStatus.error(it.message.toString()))
    }.flowOn(Dispatchers.IO)


    suspend fun fetchPokemonInformationById(id:Int) = flow {
        emit(DataStatus.loading())
        val result = retrofit.getRetrofitService().getPokemonInformationById(id)
        when(result.code()){
            200->{emit(DataStatus.success(result.body()))}
            400->{emit(DataStatus.error(result.message()))}
            500->{emit(DataStatus.error(result.message()))}
        }
    }.catch{
        emit(DataStatus.error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}