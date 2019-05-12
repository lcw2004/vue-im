package com.lcw.im.service;

import com.lcw.base.service.CrudService;
import com.lcw.im.bean.UserInfo;
import com.lcw.im.dao.UserInfoDao;
import com.lcw.im.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService extends CrudService<UserInfoDao, UserInfo, String> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public UserInfo save(UserInfo userInfo){ //新增或更改；执行更改，id字段必须有值，否则为新增
        userRepository.save(userInfo);
        return userInfo;
    }

    public List<UserInfo> getAll() {
        return userInfoDao.list();
    }

    public UserInfo findOne(String id){
        return userRepository.findById(id).get();
    }

    public void delete(UserInfo userInfo){
        userRepository.delete(userInfo);
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

}
