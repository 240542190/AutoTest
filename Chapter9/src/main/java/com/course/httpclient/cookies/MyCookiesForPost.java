package com.course.httpclient.cookies;

import com.sun.deploy.nativesandbox.comm.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    String url;
    ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void BeforeTest()
    {
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("test.getCookies.uri");
        String testUrl=this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        this.store=client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();
        for(Cookie cookie:cookieList)
        {
            String name = cookie.getName();

            String value = cookie.getValue();

            System.out.println("cookie name =" +name+ ";cookie value= "+ value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostCookies() throws IOException {

        String uri=bundle.getString("test.PostCookies.uri");
        String testUrl=this.url+uri;
        //声明client对象，用来进行方法执行
        DefaultHttpClient client=new DefaultHttpClient();
        //声明一个post方法
        HttpPost post=new HttpPost(testUrl);
        //添加参数
        JSONObject param=new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        //设置请求头
        post.setHeader("content-type","application");
        //将参数添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来存储响应结果
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response=client.execute(post);
        //获得响应结果
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果判断结果是否符合预期
        //将结果响应字符串转换为json
        JSONObject resultJson=new JSONObject(result);
        //具体判断返回的结果值
        //获取结果
        String suceess= (String) resultJson.get("huhansan");
        String status= (String) resultJson.get("status");
        Assert.assertEquals("success",suceess);
        Assert.assertEquals("1",status);




    }
}
