package com.works.overview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.works.overview.entities.Note;
import com.works.overview.redisModels.NoteRedis;
import com.works.overview.redisRepositories.NoteRedisRepository;
import com.works.overview.repositories.NoteRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteService {

    final NoteRepository noteRepository;
    final CacheManager cacheManager;

    
    public ResponseEntity save(Note note) {
        noteRepository.save(note);
        cacheManager.getCache("note").clear();
        return Util.ok(note);
    }

    @Cacheable(value = "note")
    public List<NoteRedis> list() {
        List<Note> notes = noteRepository.findAll();
        List<NoteRedis> noteRedis = new ArrayList<>();
        for (Note item : notes) {
            NoteRedis n = new NoteRedis();
            n.setId(item.getNid());
            n.setName(item.getName());
            n.setDetail(item.getDetail());
            noteRedis.add(n);
        }
        return noteRedis;
    }
    
}
