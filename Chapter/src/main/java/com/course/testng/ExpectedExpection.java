package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedExpection {

    /**
     * 期望结果为某一个异常的时候
     */

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpectionFailed(){
        System.out.println("这是一个运行失败的方法");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpectionSuccess(){
        System.out.println("这是一个运行成功的方法");
        throw  new RuntimeException();
    }
}
