package com.citysight.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AwErrorDto {
    private final String status;
    private final String message;
}
