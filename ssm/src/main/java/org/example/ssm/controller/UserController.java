package org.example.ssm.controller;

import jakarta.annotation.Resource;
import org.example.ssm.pojo.User;
import org.example.ssm.service.impl.UserServiceImpl;
import org.example.ssm.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    @PostMapping("/Login")
    public Result<User> loginController(@RequestBody User loginUser){
        User user = userService.loginService(loginUser.getEmail(), loginUser.getPassword());
        System.out.println(user);
        if(user != null){
            return Result.success(user, "登录成功");
        }else{
            return Result.error("401","账号或密码错误");
        }
    }

    @PostMapping("/Register")
    public Result<User> registerController(@RequestBody User newUser){
        User user = userService.registerService(newUser);
        if(user != null){
            return Result.success(user, "注册成功！");
        }else{
            return Result.error("402","用户名已存在！");
        }
    }
}
