package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MyHttpClient {

    @Test
    public void test1() throws Exception{


        //存放结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
//        HttpClient client = new DefaultHttpClient();//过时的方法
        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(get);
        //读取返回的结果
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while((line = reader.readLine()) != null){
            stringBuilder.append(line + "/n");
        }
        inputStream.close();
        result = stringBuilder.toString();
        System.out.println(result);
    }
}
