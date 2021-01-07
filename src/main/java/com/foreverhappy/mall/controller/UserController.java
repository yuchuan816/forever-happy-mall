package com.foreverhappy.mall.controller;

import com.foreverhappy.mall.domain.UserDO;
import com.foreverhappy.mall.service.UserService;
import com.foreverhappy.mall.utils.RestResult;
import com.foreverhappy.mall.utils.RestResultFactory;
import com.foreverhappy.mall.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="用户管理")
@RestController
@RequestMapping("/users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("用户列表")
    @GetMapping("/")
    public RestResult<List<UserVo>> getUserList() {
        return RestResultFactory.success(userService.getUserList());
    }

}
