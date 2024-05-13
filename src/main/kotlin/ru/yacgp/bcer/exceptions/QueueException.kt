package ru.yacgp.bcer.exceptions

/**
 * Исключение очереди.
 *
 * @property message Сообщение об ошибке
 * @property cause Исходное исключение
 *
 * @author Nikolay Rudakov <n.rudakov@vanguardsoft.ru>
 */
open class QueueException(
    override val message: String,
    override val cause: Throwable? = null
) : ApplicationException(message, cause) {}
