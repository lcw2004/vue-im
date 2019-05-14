package com.lcw.im.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "im_friend")
public class ImFriend {

    @Id
    private String userId;
    private String friend_id;
    private String group_id;
    private String nick_name;

}