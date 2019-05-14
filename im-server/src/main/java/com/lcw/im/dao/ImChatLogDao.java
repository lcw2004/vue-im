package com.lcw.im.dao;

import com.lcw.base.persistence.BaseRepositoryImpl;
import com.lcw.im.bean.ImChatLog;
import com.lcw.im.bean.ImUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ImChatLogDao extends BaseRepositoryImpl<ImChatLog, String> {

    @Autowired
    public ImChatLogDao(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ImChatLog.class, entityManager), entityManager);
    }

}