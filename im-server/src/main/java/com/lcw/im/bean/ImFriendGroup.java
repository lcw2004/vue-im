package com.lcw.im.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "im_friend_group")
public class ImFriendGroup {

    @Id
    private String groupId;
    private String groupName;
    private String userId;
    private String orderIndex;

}