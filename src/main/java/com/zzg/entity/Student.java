package com.zzg.entity;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    public Integer age;
    private String address;
    private Grade grade;
    private TelePhone telephone;

}
