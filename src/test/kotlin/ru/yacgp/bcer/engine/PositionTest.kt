package ru.yacgp.bcer.engine

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PositionTest {
    @Test
    fun `test wrong coordinates`() {
        Assertions.assertEquals(null, Position.getByDecartCoordinates(Pair(-1,-1)))
    }

    @Test
    fun `test specific conversion to coordinates`() {
        val positions = arrayOf(
            Position.A1,
            Position.B2,
            Position.C4
        )

        val conversions = positions.map { Position.getDecartCoordinates(it) }

        Assertions.assertTrue(conversions[0].first == 0)
        Assertions.assertTrue(conversions[0].second == 0)
        Assertions.assertTrue(conversions[1].first == 1)
        Assertions.assertTrue(conversions[1].second == 1)
        Assertions.assertTrue(conversions[2].first == 2)
        Assertions.assertTrue(conversions[2].second == 3)
    }

    @Test
    fun `test position coordinates conversion`() {
        val positions = Position.entries.toTypedArray()
        val coords = positions.map { Position.getDecartCoordinates(it) }
        positions.forEachIndexed { index, it ->
            Assertions.assertTrue(it == Position.getByDecartCoordinates(coords[index]))
        }
    }
}