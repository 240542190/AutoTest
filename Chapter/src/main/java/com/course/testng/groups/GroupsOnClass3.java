package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void teacher1()
    {
        System.out.println("GroupsOnClass3333中的teacher111111111运行");
    }

    public void teacher2()
    {
        System.out.println("GroupsOnClass3333中的teacher2222222222运行");
    }


}
