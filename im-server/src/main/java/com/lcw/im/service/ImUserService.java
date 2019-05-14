package com.lcw.im.service;

import com.lcw.base.service.CrudService;
import com.lcw.im.bean.ImUser;
import com.lcw.im.dao.ImUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImUserService extends CrudService<ImUserDao, ImUser, String> {

    @Autowired
    private ImUserDao imUserDao;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public ImUser save(ImUser imUser){
        imUserDao.save(imUser);
        return imUser;
    }

    public List<ImUser> getAll() {
        return imUserDao.list();
    }

}
