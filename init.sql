CREATE TABLE im_chat_log
(
	log_id               VARCHAR(40) NOT NULL,
	sender_id            VARCHAR(40) NULL,
	target_id            VARCHAR(40) NULL,
  target_type          INTEGER NULL,
	time                 DATETIME NULL,
  message              VARCHAR(1000) NULL,
	message_type         INTEGER NULL,
	status               INTEGER NULL,
	PRIMARY KEY (log_id)
);

CREATE TABLE im_user
(
	user_id             VARCHAR(40) NOT NULL,
	user_name           VARCHAR(50) NULL,
	account               VARCHAR(40) NULL,
	password               VARCHAR(200) NULL,
	PRIMARY KEY (user_id)
);

CREATE TABLE im_group
(
	group_id             VARCHAR(40) NOT NULL,
	group_name           VARCHAR(50) NULL,
	avatar               VARCHAR(40) NULL,
	notice               VARCHAR(200) NULL,
	user_id              VARCHAR(40) NULL,
	PRIMARY KEY (group_id)
);

CREATE TABLE im_group_user
(
	group_id             VARCHAR(40) NOT NULL,
	user_id              VARCHAR(40) NULL,
	PRIMARY KEY (group_id)
);


ALTER TABLE im_chat_log COMMENT = '聊天记录表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_chat_log MODIFY COLUMN  `log_id` VARCHAR(40) NOT NULL COMMENT '记录ID';
ALTER TABLE im_chat_log MODIFY COLUMN  `sender_id` VARCHAR(40) NULL COMMENT '发送者ID';
ALTER TABLE im_chat_log MODIFY COLUMN  `target_id` VARCHAR(40) NULL COMMENT '接收者ID';
ALTER TABLE im_chat_log MODIFY COLUMN  `time` DATETIME NULL COMMENT '发送时间';
ALTER TABLE im_chat_log MODIFY COLUMN  `message_type` INTEGER NULL COMMENT '消息类型';
ALTER TABLE im_chat_log MODIFY COLUMN  `status` INTEGER NULL COMMENT '状态';
ALTER TABLE im_chat_log MODIFY COLUMN  `message` VARCHAR(1000) NULL COMMENT '消息内容';
ALTER TABLE im_chat_log MODIFY COLUMN  `target_type` INTEGER NULL COMMENT '接受者类型';

ALTER TABLE im_group COMMENT = '聊天群表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_group MODIFY COLUMN  `group_id` VARCHAR(40) NOT NULL COMMENT '群ID';
ALTER TABLE im_group MODIFY COLUMN  `group_name` VARCHAR(50) NULL COMMENT '群名字';
ALTER TABLE im_group MODIFY COLUMN  `avatar` VARCHAR(40) NULL COMMENT '群头像';
ALTER TABLE im_group MODIFY COLUMN  `user_id` VARCHAR(40) NULL COMMENT '用户ID';
ALTER TABLE im_group MODIFY COLUMN  `notice` VARCHAR(200) NULL COMMENT '群公告';

ALTER TABLE im_user COMMENT = '用户表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_user MODIFY COLUMN  `user_id` VARCHAR(40) NOT NULL COMMENT '用户ID';
ALTER TABLE im_user MODIFY COLUMN  `user_name` VARCHAR(50) NULL COMMENT '姓名';
ALTER TABLE im_user MODIFY COLUMN  `account` VARCHAR(40) NULL COMMENT '账户';
ALTER TABLE im_user MODIFY COLUMN  `password` VARCHAR(40) NULL COMMENT '密码';

ALTER TABLE im_group_user COMMENT = '群成员表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_group_user MODIFY COLUMN  `group_id` VARCHAR(40) NOT NULL COMMENT '群ID';
ALTER TABLE im_group_user MODIFY COLUMN  `user_id` VARCHAR(40) NULL COMMENT '用户ID';

