package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    private  CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws Exception{
        String result;
        //从配置文件中拼接URL
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;
        //测试逻辑代码
        //新版本创建方法
        store = new BasicCookieStore();
        //不带cookies用这种创建
        //CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);

        //读结果
        //读取返回的结果
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            stringBuilder.append(line + "/n");
        }
        inputStream.close();
        result = stringBuilder.toString();
        System.out.println(result);

        //获取cookies

        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws Exception{
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;

        //测试逻辑代码
        HttpGet get = new HttpGet(testUrl);
        //设置cookies信息
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();
        HttpResponse response = client.execute(get);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("响应状态码为：" + statusCode);
        if (statusCode == 200){
            //读取返回的结果
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                stringBuilder.append(line + "/n");
            }
            inputStream.close();
            String result = stringBuilder.toString();
            System.out.println(result);
        }
    }

}
