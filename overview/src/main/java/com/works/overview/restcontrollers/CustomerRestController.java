package com.works.overview.restcontrollers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CustomerRestController {
    

    @GetMapping("single")
    public String single() {
        return "Ali Bilmem";
    }
    


}
