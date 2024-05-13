package ru.yacgp.bcer.exceptions

class ParseHeadersException(message: String, cause: Throwable? = null) : BcerKafkaException(message, cause)
