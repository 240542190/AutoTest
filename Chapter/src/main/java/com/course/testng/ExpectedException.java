package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {

    //这是测试结果失败的异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed()
    {
        System.out.println("这是一个失败异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess()
    {
        System.out.println("这是我的失败异常测试");
        throw new RuntimeException();
    }
}
