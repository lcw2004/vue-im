package com.lcw.im.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "im_user")
public class ImUser {

    @Id
    private String userId;
    private String userName;
    private String account;
    private String password;
    private String avatar;
    private String sign;

}