package com.myapps.pokemon.gui.homefragment

import android.graphics.Path.Direction
import android.os.Bundle
import android.view.ActionProvider
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapps.pokemon.data.pokemonsearchmodel.PokemonResponse
import com.myapps.pokemon.databinding.FragmentPokemonHomeBinding
import com.myapps.pokemon.gui.homefragment.adapter.PokemonAdapter
import com.myapps.pokemon.utils.Status
import com.myapps.pokemon.utils.isVisible
import kotlinx.coroutines.launch

class PokemonHomeFragment : Fragment() {

    private val viewModel by viewModels<PokemonHomeFragmentViewModel>()
    private var offset = 0

    private var _binding:FragmentPokemonHomeBinding?=null
    private val binding get() = _binding!!

    private lateinit var adapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //init the adapter for recycler view
        adapter = PokemonAdapter{
            navigateOnPokemonInfo(it)
        }
        binding.rvPokemonList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.rvPokemonList.adapter = adapter


        // init the buttons for navigation
        binding.leftButtonSearch.setOnClickListener{
            //call previous
            if (offset <= 0) {
                binding.leftButtonSearch.isEnabled = false
                binding.rightButtonSearch.isEnabled = true
            } else {
                offset -= 25
                viewModel.fetchPokemonsByOffset(offset = offset)
            }
        }

        binding.rightButtonSearch.setOnClickListener{
            //call next
            offset += 25
            viewModel.fetchPokemonsByOffset(offset = offset)
        }

        // get the list of pokemons to show in the fragment
        lifecycleScope.launch {
                viewModel.fetchPokemonsByOffset(offset)
                viewModel.pokemonResponse.observe(viewLifecycleOwner){
                    when(it.status){
                        Status.SUCCESS->{
                            binding.pbLoad.isVisible(false,binding.rvPokemonList)
                            binding.leftButtonSearch.isEnabled = offset > 0
                            adapter.updateList(it.data?.results!!)

                        }
                        Status.LOADING->{
                            binding.pbLoad.isVisible(true,binding.rvPokemonList)
                        }
                        Status.ERROR->{
                            binding.pbLoad.isVisible(true,binding.rvPokemonList)
                            Toast.makeText(requireContext(),"something is not working",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
    }


    //this is a function to pass for adapter. The purpose is that every element of the list of pokemon
    //could access to pokemon info fragment
    private fun navigateOnPokemonInfo(id:Int){
        val direction = PokemonHomeFragmentDirections.actionPokemonHomeFragmentToPokemonInformationFragment(id)
        findNavController().navigate(direction)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}




