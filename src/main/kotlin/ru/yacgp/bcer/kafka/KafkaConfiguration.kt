package ru.yacgp.bcer.kafka

import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.KafkaOperations
import org.springframework.kafka.listener.CommonErrorHandler
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer
import org.springframework.kafka.listener.DefaultErrorHandler
import org.springframework.kafka.support.converter.JsonMessageConverter
import org.springframework.kafka.support.converter.RecordMessageConverter
import org.springframework.util.backoff.FixedBackOff


@Configuration
@EnableKafka
class KafkaConfiguration {

//    @Bean
//    fun kafkaListenerContainerFactory(): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Int, String>> {
//        val factory =
//            ConcurrentKafkaListenerContainerFactory<Int, String>()
//        factory.consumerFactory = consumerFactory()
//        factory.setConcurrency(3)
//        factory.containerProperties.pollTimeout = 3000
//        return factory
//    }
//
//    @Bean
//    fun consumerFactory(): ConsumerFactory<Int, String> {
//        return DefaultKafkaConsumerFactory(consumerConfigs())
//    }
//
//    @Bean
//    fun consumerConfigs(): Map<String, Any> {
//        val props: MutableMap<String, Any> = HashMap()
//        return props;
//    }

    @Bean
    fun errorHandler(template: KafkaOperations<Any?, Any?>?): CommonErrorHandler {
        return DefaultErrorHandler(
            DeadLetterPublishingRecoverer(template!!), FixedBackOff(1000L, 2)
        )
    }

    @Bean
    fun converter(): RecordMessageConverter {
        return JsonMessageConverter()
    }
}