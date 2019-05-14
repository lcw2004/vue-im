package com.lcw.im.service;

import com.lcw.base.service.CrudService;
import com.lcw.im.bean.ImFriendGroup;
import com.lcw.im.bean.ImGroup;
import com.lcw.im.dao.ImFriendGroupDao;
import com.lcw.im.dao.ImGroupDao;
import org.springframework.stereotype.Service;

@Service
public class ImFriendGroupService extends CrudService<ImFriendGroupDao, ImFriendGroup, String> {

}
