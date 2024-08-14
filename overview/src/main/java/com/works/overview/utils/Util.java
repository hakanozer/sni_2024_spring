package com.works.overview.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {
    
    public static ResponseEntity ok(Object result) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        hm.put("result", result);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public static ResponseEntity fail(Object result, HttpStatus httpStatus) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status",false);
        hm.put("result", result);
        return new ResponseEntity(hm, httpStatus);
    }


}
