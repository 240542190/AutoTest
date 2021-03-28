package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1()
    {
        System.out.println("这是测试用例1");
    }

    @Test
    public void testCase2()
    {
        System.out.println("这是测试用例2");
    }

    @BeforeMethod
    public  void beforeMethod()
    {
        System.out.println("BeforeMethod这是在测试方法之前运行");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("AfterMethod这是在测试方法之后运行");
    }

    @BeforeClass
    public void  beforeClass()
    {
        System.out.println("BeforeClass这是在类运行前运行的方法");
    }

    @AfterClass
    public void  afterClass()
    {
        System.out.println("afterClass这是在类运行后运行的方法");
    }

    @BeforeSuite
    public void  beforSuite()
    {
        System.out.println("beforeSuite这是测试套件");
    }

    @AfterSuite
    public void  afterSuite()
    {
        System.out.println("afterSuite这是测试套件");
    }
}
