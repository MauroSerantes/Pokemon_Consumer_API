package com.myapps.pokemon.gui.informationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapps.pokemon.R
import com.myapps.pokemon.data.pokemoninfomodel.Pokemon
import com.myapps.pokemon.data.pokemoninfomodel.PokemonStats
import com.myapps.pokemon.data.pokemoninfomodel.PokemonTypes
import com.myapps.pokemon.data.pokemoninfomodel.Type
import com.myapps.pokemon.databinding.FragmentPokemonInformationBinding
import com.myapps.pokemon.gui.informationfragment.adapter.PokemonTypesAdapter
import com.myapps.pokemon.utils.Status
import com.myapps.pokemon.utils.convertFromDecimetresToCentimetres
import com.myapps.pokemon.utils.convertFromHectogramsToKilograms
import com.myapps.pokemon.utils.isVisible
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch


class PokemonInformationFragment : Fragment() {

    private var _binding: FragmentPokemonInformationBinding? = null
    private val binding get() = _binding!!

    private val args: PokemonInformationFragmentArgs by navArgs()
    private val viewModel: PokemonInformationViewModel by viewModels()

    private lateinit var adapter: PokemonTypesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonInformationBinding.inflate(layoutInflater, container, false)
        viewModel.fetchPokemonInformation(args.id)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // init the adapter for recycler view
        adapter = PokemonTypesAdapter()
        binding.rvPokemonTypes.layoutManager = GridLayoutManager(context, 2)
        binding.rvPokemonTypes.adapter = adapter

        //get the pokemon information to show in the fragment

        lifecycleScope.launch {
            viewModel.pokemonInfo.observe(viewLifecycleOwner){
                when(it.status){
                    Status.SUCCESS->{

                        binding.progressBar.isVisible(false,binding.infoContainer)
                        val pokemonInfo = it.data!!
                        binding.tvPokemonName.text = pokemonInfo.name
                        Picasso.get().load(pokemonInfo.sprites.other.offArtwork.frontDefault).into(binding.imgPokemon)
                        binding.tvPokemonOrder.text = pokemonInfo.order.toString()
                        binding.tvPokemonHeight.text = convertFromDecimetresToCentimetres(pokemonInfo.height).toString().plus(" cm")
                        binding.tvPokemonWeight.text = convertFromHectogramsToKilograms(pokemonInfo.weight).toString().plus(" kg")
                        binding.tvPokemonBaseExperience.text = pokemonInfo.baseExperience.toString()

                        binding.tvPokemonHp.text = pokemonInfo.stats[0].baseStat.toString()
                        binding.tvPokemonAttack.text = pokemonInfo.stats[1].baseStat.toString()
                        binding.tvPokemonDefense.text = pokemonInfo.stats[2].baseStat.toString()
                        binding.tvPokemonSpAttack.text = pokemonInfo.stats[3].baseStat.toString()
                        binding.tvPokemonSpDefense.text = pokemonInfo.stats[4].baseStat.toString()
                        binding.tvPokemonSpeed.text = pokemonInfo.stats[5].baseStat.toString()

                        adapter.updateList(pokemonInfo.types)

                    }
                    Status.LOADING->{
                        binding.progressBar.isVisible(true,binding.infoContainer)
                    }
                    Status.ERROR->{
                        binding.progressBar.isVisible(false,binding.infoContainer)
                        Toast.makeText(requireContext(),"something is not working",Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}