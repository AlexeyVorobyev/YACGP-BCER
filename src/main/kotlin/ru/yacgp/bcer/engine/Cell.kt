package ru.yacgp.bcer.engine

data class Cell(
    val position: Position,
    val figure: Figure?
) {
    override fun equals(other: Any?): Boolean {
        if (other === null) {
            return false
        }

        if (other === this) {
            return true
        }

        if (other.javaClass !== this.javaClass) {
            return false
        }

        val other = other as Cell

        return other.position === this.position
    }
}