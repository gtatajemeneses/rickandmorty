package com.gerardo.consumeapi

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.fromURL(url:String){
    Picasso.get().load(url).into(this)
}