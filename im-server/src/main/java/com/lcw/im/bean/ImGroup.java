package com.lcw.im.bean;

import javax.persistence.*;

/**
 * 聊天群
 */
@Entity
@Table(name = "im_group")
public class ImGroup {

	/**
	 * 群ID
	 */
	@Id
    @GeneratedValue
	private String groupId;

	/**
	 * 群名字
	 */
	private String groupName;

	/**
	 * 群头像
	 */
	private String avatar;

	/**
	 * 群公告
	 */
	private String notice;

	/**
	 * 用户ID
	 */
	private String userId;

    public String getGroupId () {
        return this.groupId;
    }

    public void setGroupId (String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName () {
        return this.groupName;
    }

    public void setGroupName (String groupName) {
        this.groupName = groupName;
    }

    public String getAvatar () {
        return this.avatar;
    }

    public void setAvatar (String avatar) {
        this.avatar = avatar;
    }

    public String getNotice () {
        return this.notice;
    }

    public void setNotice (String notice) {
        this.notice = notice;
    }

    public String getUserId () {
        return this.userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

}