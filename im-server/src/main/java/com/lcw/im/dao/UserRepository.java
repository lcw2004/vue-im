package com.lcw.im.dao;

import com.lcw.im.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, String> {

    UserInfo findByUserName(String userName);

}
