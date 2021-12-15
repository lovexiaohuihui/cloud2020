package com.bochao.controller1;

import com.bochao.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "博超接口说明")
@RequestMapping("/user")
public class SwaggerController1 {

    @GetMapping("/getUser")
    @ApiOperation("获取用户名")
    public String getUser(@RequestParam @ApiParam(name = "userName", value = "请输入用户名") String userName) {
        return userName;
    }

    @PostMapping("/get")
    @ApiOperation("获取用户信息")
    public User get(@ApiParam("信息") User user) {
        return user;
    }
}
