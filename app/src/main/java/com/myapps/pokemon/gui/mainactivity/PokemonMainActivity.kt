package com.myapps.pokemon.gui.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.myapps.pokemon.R
import com.myapps.pokemon.databinding.ActivityPokemonMainBinding


class PokemonMainActivity : AppCompatActivity() {

    private var  _binding:ActivityPokemonMainBinding ?=null
    private val binding get() = _binding!!
    private lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPokemonMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentHome)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.pokemonHomeFragment,
                R.id.pokemonInformationFragment
            )
        )

        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}