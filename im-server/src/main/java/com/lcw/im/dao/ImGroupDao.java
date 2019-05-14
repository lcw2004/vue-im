package com.lcw.im.dao;

import com.lcw.base.persistence.BaseRepositoryImpl;
import com.lcw.im.bean.ImGroup;
import com.lcw.im.bean.ImUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ImGroupDao extends BaseRepositoryImpl<ImGroup, String> {

    @Autowired
    public ImGroupDao(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ImGroup.class, entityManager), entityManager);
    }

}