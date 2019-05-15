package com.lcw.im.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "im_friend")
public class ImFriend {

    @Id
    private String userId;
    private String friendId;
    private String groupId;
    private String nickName;

}