package com.course.testng.multThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {

    //注解方式实现多线程，3个线程执行10次
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test()
    {
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
