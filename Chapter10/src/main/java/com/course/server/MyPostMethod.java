package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value="/",description = "这是我全部的post请求")
public class MyPostMethod {
    private static Cookie cookie;
    //用户登录获取cookies，然后登录其他接口获取列表
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ApiOperation(value="登录接口获取cookies",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value="userName",required = true)String userName,
                        @RequestParam(value="passWord",required = true)String passWord)
    {
        if(userName.equals("zhangsan")&&passWord.equals("123456"))
        {
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功了";

        }
        return "用户名密码错误";
    }
    @RequestMapping(value="/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    @ResponseBody
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u)
    {
        User user;
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("login")
                    &&cookie.getValue().equals("true")
                    &&u.getUserName().equals("zhangsan")
                    &&u.getPassWord().equals("123456"))

            {
                user=new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();

            }
        }
        return "参数不合法";
    }
}
