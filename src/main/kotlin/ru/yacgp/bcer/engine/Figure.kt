package ru.yacgp.bcer.engine

enum class Figure : FigureInterface {
    /**
     * Пешка
     * */
    PAWN {
        override val convertible = true
        override val shouldExist = false
        override val moveConfiguration = MoveConfiguration(
            specificRelativeList = listOf(
                Pair(0, 1)
            ),
            specificRelativeListWhenNotMoved = listOf(
                Pair(0, 2)
            ),
            specificRelativeListWhenEnemyOnCell = listOf(
                Pair(-1, 1), Pair(1, 1)
            )
        )
    },

    /**
     * Слон
     * */
    BISHOP {
        override val convertible = false
        override val shouldExist = false
        override val moveConfiguration = MoveConfiguration(
            streamList = listOf(
                Pair(MoveConfiguration.infinity, Pair(1, 1)),
                Pair(MoveConfiguration.infinity, Pair(1, -1)),
                Pair(MoveConfiguration.infinity, Pair(-1, 1)),
                Pair(MoveConfiguration.infinity, Pair(-1, -1))
            )
        )
    },

    /**
     * Конь
     * */
    KNIGHT {
        override val convertible = false
        override val shouldExist = false
        override val moveConfiguration = MoveConfiguration(
            specificRelativeList = listOf(
                Pair(2, 1),
                Pair(-2, 1),
                Pair(2, -1),
                Pair(-2, -1),
                Pair(1, 2),
                Pair(-1, 2),
                Pair(1, -2),
                Pair(-1, -2),
            )
        )
    },

    /**
     * Ладья
     * */
    ROOK {
        override val convertible = false
        override val shouldExist = false
        override val moveConfiguration = MoveConfiguration(
            streamList = listOf(
                Pair(MoveConfiguration.infinity, Pair(1, 0)),
                Pair(MoveConfiguration.infinity, Pair(0, 1)),
                Pair(MoveConfiguration.infinity, Pair(-1, 0)),
                Pair(MoveConfiguration.infinity, Pair(0, -1))
            )
        )
    },

    /**
     * Ферзь
     * */
    QUINN {
        override val convertible = false
        override val shouldExist = false
        override val moveConfiguration = MoveConfiguration(
            streamList = listOf(
                Pair(MoveConfiguration.infinity, Pair(1, 1)),
                Pair(MoveConfiguration.infinity, Pair(1, -1)),
                Pair(MoveConfiguration.infinity, Pair(-1, 1)),
                Pair(MoveConfiguration.infinity, Pair(-1, -1)),
                Pair(MoveConfiguration.infinity, Pair(1, 1)),
                Pair(MoveConfiguration.infinity, Pair(1, -1)),
                Pair(MoveConfiguration.infinity, Pair(-1, 1)),
                Pair(MoveConfiguration.infinity, Pair(-1, -1))
            )
        )
    },

    /**
     * Король
     * */
    KING {
        override val convertible = false
        override val shouldExist = true
        override val moveConfiguration = MoveConfiguration(
            streamList = listOf(
                Pair(1, Pair(1, 1)),
                Pair(1, Pair(1, -1)),
                Pair(1, Pair(-1, 1)),
                Pair(1, Pair(-1, -1)),
                Pair(1, Pair(1, 1)),
                Pair(1, Pair(1, -1)),
                Pair(1, Pair(-1, 1)),
                Pair(1, Pair(-1, -1))
            )
        )
    }
}