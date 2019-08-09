package com.levi.avaliator.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericToStringSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfiguration {

    @Value("\${spring.redis.port}")
    var port: Int? = null
    @Value("\${spring.redis.host}")
    var host: String? = null

    @Bean
    fun redisConnectionFactory(): JedisConnectionFactory {
        val config = RedisStandaloneConfiguration(host!!, port!!)
        return JedisConnectionFactory(config)
    }

    @Bean
    fun redisRateTemplate(): RedisTemplate<String, List<Double>> {
        val template = RedisTemplate<String, List<Double>>()
        template.setConnectionFactory(redisConnectionFactory())
        template.keySerializer = StringRedisSerializer()
        template.hashValueSerializer = GenericToStringSerializer(Int::class.java)
        template.valueSerializer = GenericToStringSerializer(Int::class.java)
        return template
    }

}