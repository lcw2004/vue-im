package com.lcw.im.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "im_friend_group")
public class ImFriendGroup {

    @Id
    private String group_id;
    private String group_name;
    private String user_id;
    private String order_index;

}