package ru.yacgp.bcer.logger

import mu.KotlinLogging
import ru.yacgp.bcer.json.JsonMapper

class BcerLogger(private val className: String) {
    /**
     * Основной логгер.
     */
    private val logger = KotlinLogging.logger(this.className)

    /**
     * Типы сообщений.
     */
    companion object DataType {
        /**
         * Тип сообщения входных данных.
         */
        const val REQUEST = "request"

        /**
         * Тип сообщения выходных данных.
         */
        const val RESPONSE = "response"

        /**
         * Тип обычного сообщения или ошибки.
         */
        const val MESSAGE = "message"
    }

    /**
     * Запись в лог информационного сообщения.
     *
     * @param dataType Тип данных
     * @param data Данные для сообщения
     */
    fun info(dataType: String, data: () -> Any?) {
        logger.info { format(dataType, data, null) }
    }

    /**
     * Запись в лог сообщения об ошибке.
     *
     * @param dataType Тип данных
     * @param data Данные для сообщения
     * @param time Время выполнения
     * @param e Исключение
     */
    fun error(dataType: String, data: () -> Any?, time: Int? = null, e: Throwable? = null) {
        logger.error(e) { format(dataType, data, time, e) }
    }

    /**
     * Запись в лог сообщения отладки.
     *
     * @param dataType Тип данных
     * @param data Данные для сообщения
     */
    fun debug(dataType: String, data: () -> Any?) {
        logger.debug { format(dataType, data, null, null) }
    }

    /**
     * Формат сообщения лога.
     *
     * Местозаменители заполняются в следующем порядке: идентификатор пользователя, идентификатор сессии пользователя,
     * IP адрес пользователя или сервиса, тип данных (`request`, `response`, `message`), полезные данные в формате JSON,
     * время выполнения, стек вызовов. Ни одно поле не является обязательным.
     *
     * @param dataType Тип данных
     * @param data Данные для сообщения
     * @param time Время выполнения
     * @param e Исключение
     */
    private fun format(dataType: String, data: () -> Any?, time: Int? = null, e: Throwable? = null): String =
        " null | null | null | $dataType | ${JsonMapper.asString(data())} | $time | ${e?.stackTraceToString()}"
}
