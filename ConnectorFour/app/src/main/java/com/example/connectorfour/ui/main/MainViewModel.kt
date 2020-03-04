package com.example.connectorfour.ui.main

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connectorfour.ui.model.Board


class MainViewModel : ViewModel() {
    val NUMBER_OF_COLUMNS: Int = 7
    val NUMBER_OF_ROWS: Int = 6

    val board: Board = Board()

    val items = board.mat
    val positionToUpdate = MutableLiveData<Int>()

    fun navigateToBottom(adapterPosition: Int) {
        val colIndex = adapterPosition % 7      //between 0 to SPAN_COUNT
        val rowIndex = adapterPosition / 7     // total elements
        Log.d(TAG, "ViewHolder Element $rowIndex $colIndex clicked.")

        //context?.let{view.setBackgroundColor(ContextCompat.getColor(context, R.color.green_color))}
        canInsert(rowIndex, colIndex)
        determineIfWinner()
    }

    fun canInsert(rowIndex: Int, colIndex: Int){
//        // rowIndex = 1, colIndex = 6   14th element   rowIndex % span_count + colIndex
//        val clickedPosition = rowIndex * 7 + colIndex
//        val current = items[clickedPosition]
//        // we found the column, now dec the row
//        for(i in 5 downTo 0) {
//            //check for every row from bottom to top if it is occupied
//            val position = i * 7 + current.y
//            val piece = items[position]
//            if(!piece.isOccupied) {
//                //it is empty, we can allocate the piece to the color of the player
//                piece.isOccupied = true
//                piece.chipColor = Color.GREEN
//                Log.d(TAG, "ViewHolder piece.isOccupied true. $position")
//                positionToUpdate.value = position
//                return position
//            }
//        }
//        //if we reach here we were not able to insert a piece in the board
//        return -1
        val piece = board.canInsert(rowIndex, colIndex)
        piece?.let{piece ->
            positionToUpdate.value = piece.position
            Log.d(TAG, "MainViewModel Before board.currentPlayer.value ${board.currentPlayer.value}")

            board.currentPlayer.value?.let {it ->
                Log.d(TAG, "MainViewModel it ${it}")
                piece.chipColor = board.players[it].chipColor
                Log.d(TAG, "MainViewModel piece.chipColor ${piece.chipColor}")
                val current = it + 1
                board.currentPlayer.value = current % 2
                Log.d(TAG, "MainViewModel After board.currentPlayer.value ${board.currentPlayer.value}")
            }
        }
    }

    fun onItemClick(position: Int?) {
        Log.d(TAG, "ViewHolder item position clicked $position")
    }
    companion object {
        private val TAG = "MainViewModel"
    }
}
