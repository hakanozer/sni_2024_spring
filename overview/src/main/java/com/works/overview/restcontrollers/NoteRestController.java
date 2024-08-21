package com.works.overview.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.works.overview.entities.Note;
import com.works.overview.entities.Product;
import com.works.overview.services.NoteService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("note")
public class NoteRestController {

    final NoteService noteService;

    @PostMapping("save")
    public ResponseEntity save(@RequestBody Note note) {        
        return noteService.save(note);
    }

    @GetMapping("list")
    public ResponseEntity list() {
        return noteService.list();
    }
    
}
