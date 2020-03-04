package com.example.connectorfour.ui.main

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConnectFourGameViewModel(
    val board: Board = Board()
): ViewModel() {
}
data class Board(val noRows: Int = 6, val noCols: Int = 7) {
    val boardState = MutableLiveData<BoardState>()
    init {
        boardState.value = BoardState.INITIAL
    }
    val map = mutableMapOf<Int, BoardCell>().apply {
        var count = 0
        for (i in 0 until noRows) {
            for (j in 0 until noCols) {
                put(count, BoardCell(i, j, BoardCell.HOLLOW, false))
                count++
            }
        }
    }
    fun getBoardCell(position: Int): BoardCell? {
        return map.get(position)
    }
    private var currentPlayer: Int = 0
    private val players = arrayOf(Player(BoardCell.RED), Player(BoardCell.YELLOW))
    fun onBoardInput(position: Int) {
        var pos = manipulateToBottom(position)
        boardState.value = BoardState.BOARD_UPDATING
        map.get(pos)?.let {
            map.put(pos, it.copy(color = players[currentPlayer].chipColor, isUsed = true))
            currentPlayer = (currentPlayer + 1) % 2
            boardState.value = BoardState.WAITING_FOR_INPUT
        }
    }
    private fun manipulateToBottom(postion: Int): Int {
        var newPosition = 0
        map.get(postion)?.let { boardCell ->
            boardCell.x
            boardCell.y
            // rowIndex * noCols + colIndex
            for(i in 5 downTo 0) {
                newPosition = i * 7 + boardCell.y
                map.get(newPosition)?.let { eleCell ->
                    if (!eleCell.isUsed) {
                        return newPosition
                    }
                }
            }
        }
        return newPosition
    }
    enum class BoardState {
        INITIAL,
        WIN,
        WAITING_FOR_INPUT,
        BOARD_UPDATING
    }
}

data class BoardCell(val x: Int, val y: Int, val color: Int, val isUsed: Boolean = false) {
    companion object {
        val RED = Color.RED
        val YELLOW = Color.YELLOW
        val HOLLOW = Color.GREEN
    }
}
data class Player(val chipColor: Int = 0)