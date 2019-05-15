package com.lcw.im.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * 聊天群
 */
@Data
@Entity
@Table(name = "im_group")
public class ImGroup {

	@Id
	private String groupId;
    private String userId;
	private String groupName;
	private String avatar;
	private String notice;

}