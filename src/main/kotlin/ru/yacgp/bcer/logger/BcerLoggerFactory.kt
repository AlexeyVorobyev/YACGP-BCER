package ru.yacgp.bcer.logger

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class BcerLoggerFactory() {
    /**
     * Список логгеров в качестве кеша.
     */
    private val loggers = ConcurrentHashMap<Class<*>, BcerLogger>()

    /**
     * Возвращает логгер по классу вызывающего класса.
     *
     * @param caller Класс
     *
     * @return Логгер
     */
    fun getLogger(caller: Class<*>?): BcerLogger {
        val key = caller?.name ?: "UnknownClass"
        return loggers.getOrPut(caller) { BcerLogger(key) }
    }
}
