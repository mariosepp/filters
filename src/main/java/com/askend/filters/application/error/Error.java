package com.askend.filters.application.error;

import lombok.Builder;

import java.util.List;

@Builder
public class Error {
    private String code;
    private String message;
    private List<String> fields;
}
