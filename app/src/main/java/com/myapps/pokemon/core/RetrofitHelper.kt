package com.myapps.pokemon.core

import com.myapps.pokemon.data.network.PokemonApiService
import com.myapps.pokemon.utils.ServiceConstants.BASE_POKEMON_URL
import com.myapps.pokemon.utils.ServiceConstants.TIME_NETWORK
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitHelper{

    fun getRetrofitService(): PokemonApiService = Retrofit
            .Builder()
            .baseUrl(BASE_POKEMON_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
            .create(PokemonApiService::class.java)


    private fun getInterceptor():HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    private fun getClient() = OkHttpClient
        .Builder()
        .addInterceptor(getInterceptor())
        .connectTimeout(TIME_NETWORK,TimeUnit.SECONDS)
        .readTimeout(TIME_NETWORK,TimeUnit.SECONDS)
        .writeTimeout(TIME_NETWORK,TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()
}



