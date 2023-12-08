package com.myapps.pokemon.gui.informationfragment.adapter



import android.content.Context
import android.content.res.Resources
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.myapps.pokemon.R
import com.myapps.pokemon.data.pokemoninfomodel.PokemonTypes
import com.myapps.pokemon.databinding.PokemonItemTypesBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class PokemonTypesViewHolder(view:View,private val context: Context):ViewHolder(view){
    private val binding = PokemonItemTypesBinding.bind(view)

    fun render(pokemonType: PokemonTypes){
        binding.tvPokemonType.text  = pokemonType.type.name

     when(pokemonType.type.name){
            "bug"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.bug_color)
                )

            }
            "dark"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.dark_color)
                )
            }
            "dragon"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.dragon_color)
                )
            }
            "electric"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.electric_color)
                )
            }
            "fairy"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.fairy_color)
                )
            }
            "fighting"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.fighting_color)
                )
            }
            "fire"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.fire_color)
                )
            }
            "flying"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.flying_color)
                )
            }
            "ghost"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.ghost_color)
                )
            }
            "grass"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.grass_color)
                )
            }
            "ground"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.ground_color)
                )
            }
            "ice"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.ice_color)
                )
            }
            "normal"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.normal_color)
                )
            }
            "poison"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.poison_color)
                )
            }
            "psychic"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.psychic_color)
                )
            }
            "rock"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.rock_color)
                )
            }
            "steel"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.steel_color)
                )
            }
            "water"->{
                binding.cvType.setCardBackgroundColor(
                    ContextCompat.getColor(context,R.color.water_color)
                )
            }

        }
    }

}