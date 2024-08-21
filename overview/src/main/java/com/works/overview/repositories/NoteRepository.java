package com.works.overview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.overview.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
}
