package com.lcw.im.rest;

import com.lcw.base.bean.ResponseMessage;
import com.lcw.base.bean.Result;
import com.lcw.im.service.ImUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/im/user")
@Api(description = "IM用户")
public class ImUserRestController {

    @Autowired
    private ImUserService imUserService;

    @GetMapping("")
    @ApiOperation(value = "初始化")
    public ResponseMessage list() {
        return Result.success(imUserService.findAll());
    }

}
