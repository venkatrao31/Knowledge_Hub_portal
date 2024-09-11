package com.accumenta.Knowledge_Hub_Portal.dto;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private T object;
    private String message;

    public ResponseWrapper(T object) {
        super();
        this.object = object;
    }

    public ResponseWrapper(String message) {
        super();
        this.message = message;
    }
}
