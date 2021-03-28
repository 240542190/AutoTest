package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuit()
    {
        System.out.println("before suite运行啦");
    }

    @AfterSuite
    public void afterSuit()
    {
        System.out.println("after suite 运行啦");
    }

    @BeforeTest
    public void beforTest()
    {
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("AfterTest");
    }
}
