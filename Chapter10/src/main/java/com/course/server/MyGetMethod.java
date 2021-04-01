package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value="通过这个方法可以获取到cookies",httpMethod = "GET")
    //HttpServletetRequest 装请求信息的类
    //HttpServLetResponse 装响应信息的类
    public String getCookies(HttpServletResponse response)
    {
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }
    /**
     * 要求客户端携带cookies访问
     */
    @RequestMapping(value="/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value="要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookie(HttpServletRequest request)
    {
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies))
        {
            return "你必须携带cookies信息";
        }
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("login")&&
            cookie.getValue().equals("true"))
            {
                return "这是一个携带cookies信息才能访问的请求";
            }
        }
        return "你必须携带cookies信息";
    }
    /*
    开发一个需要携带参数才能访问的get请求
    第一种实现方法URL：key=value&key=value
    模拟获取商品列表
    * */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value="需要携带参数才能访问的get请求",httpMethod = "GET")
    public Map<String ,Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end){
        Map<String,Integer>myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("裤子",500);
        myList.put("衣服",600);
        return myList;
    }

     /*
    开发一个需要携带参数才能访问的get请求
    第二种实现方法URL：ip:port/get/with/param/10/20
    模拟获取商品列表
    * */
     @RequestMapping(value = "/get/with/param/{start}/{end}")
     @ApiOperation(value="需要携带参数才能访问的get请求第二种方法",httpMethod = "GET")
     public Map myGetList(@PathVariable Integer start,
                          @PathVariable Integer end)
     {
         Map<String,Integer>myList=new HashMap<>();
         myList.put("鞋",400);
         myList.put("裤子",500);
         myList.put("衣服",600);
         return myList;
     }
}
