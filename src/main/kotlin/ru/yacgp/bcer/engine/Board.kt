package ru.yacgp.bcer.engine

class Board(
    val boardConfiguration: Map<Position, Figure>
) {
    private val cellList = Position.entries.map { Cell(it, boardConfiguration[it]) }

    companion object {
        fun calculatePossibleMoves(cell: Cell): List<Pair<Int,Int>> {

        }

        private fun stream(figure: Figure): List<Pair<Int, Int>> {

        }
    }
}