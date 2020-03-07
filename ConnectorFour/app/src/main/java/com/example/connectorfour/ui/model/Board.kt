package com.example.connectorfour.ui.model

import android.graphics.Color
import androidx.lifecycle.MutableLiveData

class Board(val numsRows: Int = 7, val numCols: Int = 7) {
    var currentPlayer = MutableLiveData<Int>()
    val players = arrayOf(
        Player(Color.GREEN),
        Player(Color.RED)
    )

    var mat = arrayOf<Piece>()

    init {
        for (i in 0..6) {
            for (j in 0..6) {
                mat  += Piece(i, j)
            }
        }
        currentPlayer.value = 1
    }

    fun canInsert(rowIndex: Int, colIndex: Int) : Piece?{
        // rowIndex = 1, colIndex = 6   14th element   rowIndex % span_count + colIndex
        val clickedPosition = rowIndex * numCols + colIndex
        val current = mat[clickedPosition]
        // we found the column, now dec the row
        for(i in numsRows-1 downTo 0) {
            //check for every row from bottom to top if it is occupied
            val position = i * numCols + current.y
            val piece = mat[position]
            if(!piece.isOccupied) {
                //it is empty, we can allocate the piece to the color of the player
                piece.isOccupied = true
                piece.x = i
                piece.y = current.y
                piece.position = position
                return piece
            }
        }
        //if we reach here we were not able to insert a piece in the board
        return null
    }
}
