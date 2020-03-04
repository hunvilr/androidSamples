package com.example.connectorfour.ui.model

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.databinding.Bindable

class Piece(val x: Int, val y: Int) {
    var chipColor = Color.GRAY
        set(value) {
            if(isOccupied){
                field = Color.GREEN
            }
        }
    var isOccupied: Boolean = false
        set(value) {
            if (field != value) {
                field = value
            }
        }
}