package com.works.overview.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.works.overview.entities.Info;
import com.works.overview.repositories.InfoRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("info")
@RequiredArgsConstructor
public class InfoRestController {

    final InfoRepository infoRepository;

    @GetMapping("list")
    public ResponseEntity list() {
        List<Info> infos = infoRepository.findAll();
        return Util.ok(infos);
    }
    
    
}
