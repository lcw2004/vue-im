package com.lcw.im.service;

import com.lcw.base.service.CrudService;
import com.lcw.im.bean.ImChatLog;
import com.lcw.im.bean.ImUser;
import com.lcw.im.dao.ImChatLogDao;
import com.lcw.im.dao.ImUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImChatLogService extends CrudService<ImChatLogDao, ImChatLog, String> {

}
