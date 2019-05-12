package com.lcw.im.dao;

import com.lcw.base.persistence.BaseRepositoryImpl;
import com.lcw.im.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class UserInfoDao extends BaseRepositoryImpl<UserInfo, String> {

    @Autowired
    public UserInfoDao(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(UserInfo.class, entityManager), entityManager);
    }

    public List<UserInfo> list() {
        return executeList("from UserInfo");
    }

}