package ru.yacgp.bcer.engine

interface FigureInterface {
    val convertible: Boolean
    val shouldExist: Boolean
    val moveConfiguration: MoveConfiguration
}