package com.works.overview.redisModels;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@RedisHash("note")
@Data
public class NoteRedis {

    private Long id;
    private String name;
    private String detail;
    
}
