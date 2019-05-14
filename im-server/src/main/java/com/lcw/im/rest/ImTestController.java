package com.lcw.im.rest;

import com.lcw.base.bean.ResponseMessage;
import com.lcw.base.bean.Result;
import com.lcw.base.utils.UUID;
import com.lcw.im.bean.ImUser;
import com.lcw.im.service.ImUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/im/test")
@Api(description = "IM")
public class ImTestController {

    @Autowired
    private ImUserService imUserService;

    @GetMapping("/genUser")
    @ApiOperation(value = "初始化")
    public ResponseMessage genUser() {
        List<String> list = Arrays.asList("司惜寒", "籍慧恩", "靳聪慧", "周束芳", "相兰芳", "巴怡宁", "聂琳涵", "景雅致", "张娇洁", "薛姝瑶", "尹春柏", "牧静槐", "宓香馨", "张傲南", "敖宫莹", "游笛韵", "漕翠丝", "宋从安", "林傲玉", "厉语海", "廖芫华", "姚杰秀", "龚慧秀", "尹冰之", "甘思艳", "祖平乐", "靳映之", "邴梓燕", "党奕奕", "充秋彤", "郝书仪", "汤雅诗", "麴松雪", "任诗云", "空怡丞", "庄觅露", "谢晓彤", "池妍晨", "詹怡金", "班郁安", "班俨雅", "甘悦玮", "扈平霞", "彭叶澜", "曾亚玲", "仰叶春", "后笑珊", "傅维娟", "杨丹烟", "甘小瑜", "龙奕叶", "丁梅雪", "梁隅晖", "能艳红", "戈仙媛", "乌清茹", "范棠华", "广春荷", "戴梦琪", "邴怡月", "吕凌波", "宿友卉", "尚以晴", "胡含景", "何依心", "赖妍雅", "钭书蝶", "谭尔芙", "汲梓婧", "贡初雪", "乔书怡", "钱悠素", "浦胜怡", "胡欢欣", "卓笑珊", "瞿吉玉", "萧友桃", "邓琇晶", "车大梅", "姚静美", "国湛霞", "钟芮美", "高郁蓝", "禄惠美", "郝向珊", "关灵薇", "相仙韵", "燕婷丽", "魏芷荷", "宰嘉淑", "万正平", "易梦菡", "金翠玲", "鄂涵易", "耿依心", "耿宵雨", "孔春晓", "糜冰凡", "宿叶飞", "宋清茹");

        for(String name: list) {
            ImUser imUser = new ImUser();
            imUser.setUserId(UUID.randomUUID10());
            imUser.setUserName(name);
            imUser.setAccount(name);
            imUser.setPassword("1");
            imUserService.save(imUser);
        }
        return Result.success();
    }

}
