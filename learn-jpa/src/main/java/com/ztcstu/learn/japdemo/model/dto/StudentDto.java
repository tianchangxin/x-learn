package com.ztcstu.learn.japdemo.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
    private String name;
    private String phone;
}
