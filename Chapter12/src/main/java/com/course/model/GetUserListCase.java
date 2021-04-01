package com.course.model;

import lombok.Data;

@Data
public class GetUserListCase {

    private String userName;
    private String age;

    private int sex;

    private String expected;
}
