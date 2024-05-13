package ru.yacgp.bcer.engine

/**
 * Класс конфигурирующий возможные ходы фигуры
 *
 * @property streamList - Дистанция, направление по декарту
 * @property specificRelativeList - Специфичные точки относительно текущего местоположения
 * @property specificList - Специфичные точки
 * */
class MoveConfiguration(
    val streamList: List<Pair<Int, Pair<Int, Int>>>? = null,
    val specificRelativeList: List<Pair<Int,Int>>? = null,
    val specificList: List<Pair<Int,Int>>? = null,
    val specificRelativeListWhenNotMoved: List<Pair<Int,Int>>? = null,
    val specificRelativeListWhenEnemyOnCell: List<Pair<Int,Int>>? = null
) {
    companion object {
        const val infinity = 1000
    }
}