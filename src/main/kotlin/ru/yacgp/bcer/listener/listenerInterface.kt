package ru.yacgp.bcer.listener

import com.fasterxml.jackson.databind.JsonNode


/**
 * Интерфейс слушателя события из шины сообщений и ответа
 * */
interface listenerInterface {
    fun reducer(input: JsonNode): Unit
    fun producer(input: JsonNode): Unit
}