package com.myapps.pokemon.utils

import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat

fun convertFromDecimetresToCentimetres(value:Int):Int = value*10

fun convertFromHectogramsToKilograms(value:Int):Double = value.toDouble()/10

fun View.isVisible(isShowLoading:Boolean, container: View){
    if(isShowLoading){
        this.visibility = View.VISIBLE
        container.visibility = View.GONE
    }
    else{
        this.visibility = View.GONE
        container.visibility = View.VISIBLE
    }
}


fun Context.getCompatColor(@ColorRes colorId: Int) =
    ResourcesCompat.getColor(resources, colorId, null)