package com.lcw.im.dao;

import com.lcw.base.persistence.BaseRepositoryImpl;
import com.lcw.im.bean.ImUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ImUserDao extends BaseRepositoryImpl<ImUser, String> {

    @Autowired
    public ImUserDao(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ImUser.class, entityManager), entityManager);
    }

    public List<ImUser> list() {
        return executeList("from ImUser");
    }

}