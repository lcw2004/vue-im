package com.lcw.im.dao;

import com.lcw.base.persistence.BaseRepositoryImpl;
import com.lcw.im.bean.ImFriend;
import com.lcw.im.bean.ImGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ImFriendDao extends BaseRepositoryImpl<ImFriend, String> {

    @Autowired
    public ImFriendDao(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ImFriend.class, entityManager), entityManager);
    }

}