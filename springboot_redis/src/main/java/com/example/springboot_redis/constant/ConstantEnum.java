package com.example.springboot_redis.constant;

public enum ConstantEnum {

    STR_TOPIC("string_topic"),

    STU_TOPIC("student_topic");

    private String value;

    ConstantEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
