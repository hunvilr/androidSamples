package com.example.connectorfour.ui.model

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.connectorfour.ui.main.BoardCell
import com.example.connectorfour.ui.main.MainViewModel

class Board {
    var currentPlayer = MutableLiveData<Int>()
    val players = arrayOf(
        Player(Color.GREEN),
        Player(Color.RED)
    )
//    init {
//        for(i in 0..12) {
//            mat += Piece(i, i)
//        }
//    }

//    var mat = arrayOf<Array<Piece>>()
//
//    init {
//        for (i in 0..5) {
//            var subArray = arrayOf<Piece>()
//            for (j in 0..6) {
//                subArray  += Piece(i, j)
//            }
//            mat += subArray
//        }
//    }

    var mat = arrayOf<Piece>()

    init {
        for (i in 0..5) {
            for (j in 0..6) {
                mat  += Piece(i, j)
            }
        }
        currentPlayer.value = 1
    }

//    var mat = arrayOf<String>()
//
//    init {
//        for (i in 0..5) {
//            for (j in 0..6) {
//                mat  += String("$i  $j".toCharArray())
//            }
//        }
//    }
    fun canInsert(rowIndex: Int, colIndex: Int) : Piece?{
        // rowIndex = 1, colIndex = 6   14th element   rowIndex % span_count + colIndex
        val clickedPosition = rowIndex * 7 + colIndex
        val current = mat[clickedPosition]
        // we found the column, now dec the row
        for(i in 5 downTo 0) {
            //check for every row from bottom to top if it is occupied
            val position = i * 7 + current.y
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
