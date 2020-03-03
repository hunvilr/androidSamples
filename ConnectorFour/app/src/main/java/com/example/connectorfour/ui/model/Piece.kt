package com.example.connectorfour.ui.model

import androidx.databinding.Bindable

class Piece(val x: Int, val y: Int) {
    enum class Piece_COLOR {
        GRAY,
        GREEN,
        RED
    }

    var isOccupied: Boolean = false
        set(value) {
            if (field != value) {
                field = value
            }
        }
}