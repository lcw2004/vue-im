package com.lcw.im.service;

import com.lcw.base.service.CrudService;
import com.lcw.im.bean.ImGroup;
import com.lcw.im.bean.ImUser;
import com.lcw.im.dao.ImGroupDao;
import com.lcw.im.dao.ImUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImGroupService extends CrudService<ImGroupDao, ImGroup, String> {

}
