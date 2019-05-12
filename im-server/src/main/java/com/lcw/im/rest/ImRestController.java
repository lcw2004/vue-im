package com.lcw.im.rest;

import com.lcw.base.bean.ResponseMessage;
import com.lcw.base.bean.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/im")
@Api(description = "IM")
public class ImRestController {

    @ApiOperation(value = "仓库详情")
    @GetMapping("/init")
    public ResponseMessage get(@PathVariable String id) {
        return Result.success(1234567);
    }

}
