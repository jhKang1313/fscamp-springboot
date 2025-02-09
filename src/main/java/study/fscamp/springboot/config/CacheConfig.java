package study.fscamp.springboot.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@EnableCaching
@Configuration
public class CacheConfig {
  @Bean
  public RedisCacheConfiguration redisCacheConfiguraion(){
    return RedisCacheConfiguration.defaultCacheConfig()
        .computePrefixWith(name -> name + ":")    // redis 에 저장되는 cache id 구분자를 :: 에서 : 로 변경
        .entryTtl(Duration.ofSeconds(10))         // time to live -> 10 초 뒤에 등록된 캐시 삭제
        .serializeValuesWith(
            RedisSerializationContext.SerializationPair.fromSerializer(
                new GenericJackson2JsonRedisSerializer()

            )
        );
  }
}
