package com.lcw.im.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 聊天记录
 */
@Data
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

}