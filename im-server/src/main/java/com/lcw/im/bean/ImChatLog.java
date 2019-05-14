package com.lcw.im.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 聊天记录
 */
@Entity
@Table(name = "im_chat_log")
public class ImChatLog {

	@Id
	private String logId;
	private String senderId;
	private String targetId;
	private Integer targetType;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;
	private String message;
	private Integer messageType;
	private Integer status;

    public String getLogId () {
        return this.logId;
    }

    public void setLogId (String logId) {
        this.logId = logId;
    }

    public String getSenderId () {
        return this.senderId;
    }

    public void setSenderId (String senderId) {
        this.senderId = senderId;
    }

    public String getTargetId () {
        return this.targetId;
    }

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public Integer getTargetType () {
        return this.targetType;
    }

    public void setTargetType (Integer targetType) {
        this.targetType = targetType;
    }

    public Date getTime () {
        return this.time;
    }

    public void setTime (Date time) {
        this.time = time;
    }

    public String getMessage () {
        return this.message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public Integer getMessageType () {
        return this.messageType;
    }

    public void setMessageType (Integer messageType) {
        this.messageType = messageType;
    }

    public Integer getStatus () {
        return this.status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

}