package ru.yacgp.bcer.listener

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.yacgp.bcer.json.JsonMapper
import ru.yacgp.bcer.logger.BcerLogger


@Service
class CheckMoveListener : listenerInterface {
    @Autowired
    private lateinit var template: KafkaTemplate<Any, Any>

    @Autowired
    private lateinit var logger: BcerLogger

    @KafkaListener(id = "1", topics = ["bcer.check-move.request"])
    override fun reducer(input: JsonNode): Unit {
        logger.info("bcer.check-move.request") { JsonMapper.asString(input) }
        println(input)
    }

    override fun producer(input: JsonNode): Unit {
        TODO("Not yet implemented")
    }

}