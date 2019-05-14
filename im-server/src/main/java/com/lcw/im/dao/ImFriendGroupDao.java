package com.lcw.im.dao;

import com.lcw.base.persistence.BaseRepositoryImpl;
import com.lcw.im.bean.ImFriendGroup;
import com.lcw.im.bean.ImGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ImFriendGroupDao extends BaseRepositoryImpl<ImFriendGroup, String> {

    @Autowired
    public ImFriendGroupDao(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ImFriendGroup.class, entityManager), entityManager);
    }

}