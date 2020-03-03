package com.example.connectorfour.ui.model

class Board {
    val player1 : Player = Player()
    val player2 : Player = Player()

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
}
