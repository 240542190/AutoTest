package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {

    public void stu1()
    {
        System.out.println("GroupsOnClass11111中的stu1运行方法1111111");
    }

    public void stu2()
    {
        System.out.println("GroupsOnClass111111中的stu2运行方法2222222");
    }
}
