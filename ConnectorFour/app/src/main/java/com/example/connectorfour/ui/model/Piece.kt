package com.example.connectorfour.ui.model

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.databinding.Bindable

class Piece(var x: Int, var y: Int) {
    var position = -1
    var chipColor = Color.GRAY
    var isOccupied: Boolean = false
        set(value) {
            if (field != value) {
                field = value
            }
        }
}