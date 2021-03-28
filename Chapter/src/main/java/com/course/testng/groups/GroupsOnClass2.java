package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stu1()
    {
        System.out.println("GroupsOnClass22222中的stu1运行方法1111111");
    }

    public void stu2()
    {
        System.out.println("GroupsOnClass22222中的stu2运行方法2222222");
    }
}
