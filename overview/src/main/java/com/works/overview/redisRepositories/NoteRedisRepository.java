package com.works.overview.redisRepositories;

import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;

import com.works.overview.redisModels.NoteRedis;

@EnableRedisRepositories
public interface NoteRedisRepository extends CrudRepository<NoteRedis, String> {
    
}
