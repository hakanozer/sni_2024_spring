package com.works.overview.configs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.works.overview.utils.Util;

@RestControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid( MethodArgumentNotValidException ex ) {
        return Util.fail( parseError(ex.getFieldErrors()), HttpStatus.BAD_REQUEST);
    }

    private List parseError(List<FieldError> fieldErrors) {
        List list = new ArrayList<>();
        for(FieldError error: fieldErrors) {
            String field = error.getField();
            String defaultMessage = error.getDefaultMessage();
            Object rejectedValue = error.getRejectedValue();
            Map map = new LinkedHashMap<>();
            map.put("field", field);
            map.put("defaultMessage", defaultMessage);
            map.put("rejectedValue", rejectedValue);
            list.add(map);
        }
        return list;
    }



}
