package ru.yacgp.bcer.logger

import org.springframework.beans.factory.InjectionPoint
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class LoggerConfiguration(val bcerLoggerFactory: BcerLoggerFactory) {
    /**
     * Возвращает логгер.
     *
     * @param injectionPoint Точка запроса логгера
     *
     * @return Логгер
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun logger(injectionPoint: InjectionPoint): BcerLogger =
        if (injectionPoint.methodParameter == null) {
            if (injectionPoint.field != null) {
                this.bcerLoggerFactory.getLogger(injectionPoint.field!!.declaringClass)
            } else {
                this.bcerLoggerFactory.getLogger(LoggerConfiguration::class.java)
            }
        } else {
            this.bcerLoggerFactory.getLogger(injectionPoint.methodParameter!!.containingClass)
        }
}
