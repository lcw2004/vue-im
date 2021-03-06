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
@RequestMapping(value = "/api/im")
@Api(description = "IM")
public class ImRestController {

    @Autowired
    private ImUserService imUserService;

    @GetMapping("/init")
    @ApiOperation(value = "初始化")
    public ResponseMessage init() {
        return Result.success(imUserService.getAll());
    }

}
