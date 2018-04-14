package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("测试用例1");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void testCase2(){
        System.out.println("测试用例2");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    //每个方法运行之前都执行一次
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("测试方法之前运行");
    }

    //每个方法运行之后都执行一次
    @AfterMethod
    public void afterMethod(){
        System.out.println("测试方法之后运行");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @BeforeSuite
    public void beforSuite(){
        System.out.println("beforSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }
}
