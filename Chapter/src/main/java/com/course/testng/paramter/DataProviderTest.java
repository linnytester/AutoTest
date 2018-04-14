package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testdataProvider(String name,int age){
        System.out.println("name = " + name + ",age = " + age);
    }

    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"lin",26},
                {"tom",23},
                {"sky",27}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1:name = " + name + ",age = " + age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2:name = " + name + ",age = " + age);
    }

    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"ty",30},
                    {"bobo",33},
                    {"jerry",37}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"tim",40},
                    {"lucy",43},
                    {"Ai",47}
            };
        }

        return result;
    }
}
