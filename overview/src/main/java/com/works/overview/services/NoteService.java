package com.works.overview.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.works.overview.entities.Note;
import com.works.overview.entities.Product;
import com.works.overview.repositories.NoteRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteService {

    final NoteRepository noteRepository;

    public ResponseEntity save(Note note) {
        noteRepository.save(note);
        return Util.ok(note);
    }

    public ResponseEntity list() {
        return Util.ok(noteRepository.findAll());
    }
    
}
