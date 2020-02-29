package com.example.connectorfour.ui.main

import androidx.lifecycle.ViewModel
import com.example.connectorfour.ui.model.Board

class MainViewModel : ViewModel() {
    val NUMBER_OF_COLUMNS: Int = 7
    val NUMBER_OF_ROWS: Int = 6

    val board: Board = Board()

    val items = board.mat
}
