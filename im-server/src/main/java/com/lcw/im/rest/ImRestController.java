package com.lcw.im.rest;

import com.lcw.base.bean.ResponseMessage;
import com.lcw.base.bean.Result;
import com.lcw.im.service.ImUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/im")
public class ImRestController {

    @Autowired
    private ImUserService imUserService;

    @GetMapping("/init")
    public ResponseMessage get() {
        return Result.success(imUserService.getAll());
    }

}
