CREATE TABLE im_chat_log
(
	log_id               VARCHAR(40) NOT NULL,
	sender_id            VARCHAR(20) NULL,
	target_id            VARCHAR(20) NULL,
	time                 DATETIME NULL,
	message_type         INTEGER NULL,
	status               INTEGER NULL,
	message              VARCHAR(1000) NULL,
	target_type          INTEGER NULL,
	PRIMARY KEY (log_id)
);

CREATE TABLE im_friend
(
	user_id              VARCHAR(20) NOT NULL,
	friend_id            VARCHAR(20) NOT NULL,
	group_id             VARCHAR(20) NULL,
	nick_name            VARCHAR(40) NULL,
	PRIMARY KEY (user_id, friend_id)
);

CREATE TABLE im_friend_group
(
	group_id             VARCHAR(20) NOT NULL,
	group_name           VARCHAR(20) NULL,
	user_id              VARCHAR(20) NOT NULL,
	order_index          INTEGER NULL,
	PRIMARY KEY (group_id)
);

CREATE TABLE im_group
(
	group_id             VARCHAR(20) NOT NULL,
	group_name           VARCHAR(50) NULL,
	avatar               VARCHAR(200) NULL,
	user_id              VARCHAR(20) NULL,
	notice               VARCHAR(200) NULL,
	PRIMARY KEY (group_id)
);

CREATE TABLE im_group_user
(
	group_id             VARCHAR(20) NOT NULL,
	nick_name            VARCHAR(40) NULL,
	user_id              VARCHAR(20) NOT NULL,
	PRIMARY KEY (group_id,user_id)
);

CREATE TABLE im_user
(
	user_id              VARCHAR(20) NOT NULL,
	user_name            VARCHAR(40) NULL,
	account              VARCHAR(40) NULL,
	password             VARCHAR(20) NULL,
	avatar               VARCHAR(200) NULL,
	sign                 VARCHAR(100) NULL,
	PRIMARY KEY (user_id)
);

ALTER TABLE im_chat_log COMMENT = '聊天记录表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_chat_log MODIFY COLUMN `log_id` VARCHAR(40) NOT NULL COMMENT '记录ID';
ALTER TABLE im_chat_log MODIFY COLUMN `sender_id` VARCHAR(20) NULL COMMENT '发送者ID';
ALTER TABLE im_chat_log MODIFY COLUMN `target_id` VARCHAR(20) NULL COMMENT '接收者ID';
ALTER TABLE im_chat_log MODIFY COLUMN `time` DATETIME NULL COMMENT '发送时间';
ALTER TABLE im_chat_log MODIFY COLUMN `message_type` INTEGER NULL COMMENT '消息类型';
ALTER TABLE im_chat_log MODIFY COLUMN `status` INTEGER NULL COMMENT '状态';
ALTER TABLE im_chat_log MODIFY COLUMN `message` VARCHAR(1000) NULL COMMENT '消息内容';
ALTER TABLE im_chat_log MODIFY COLUMN `target_type` INTEGER NULL COMMENT '接受者类型';

ALTER TABLE im_friend COMMENT = '朋友表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_friend MODIFY COLUMN `user_id` VARCHAR(20) NOT NULL COMMENT '用户ID';
ALTER TABLE im_friend MODIFY COLUMN `group_id` VARCHAR(20) NOT NULL COMMENT '分组ID';
ALTER TABLE im_friend MODIFY COLUMN `friend_id` VARCHAR(20) NULL COMMENT '朋友ID';
ALTER TABLE im_friend MODIFY COLUMN `nick_name` VARCHAR(40) NULL COMMENT '昵称';

ALTER TABLE im_friend_group COMMENT = '朋友分组表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_friend_group MODIFY COLUMN `group_id` VARCHAR(20) NOT NULL COMMENT '分组ID';
ALTER TABLE im_friend_group MODIFY COLUMN `user_id` VARCHAR(20) NOT NULL COMMENT '用户ID';
ALTER TABLE im_friend_group MODIFY COLUMN `group_name` VARCHAR(20) NULL COMMENT '分组名称';
ALTER TABLE im_friend_group MODIFY COLUMN `order_index` INTEGER NULL COMMENT '排序号';

ALTER TABLE im_group COMMENT = '聊天群'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_group MODIFY COLUMN `group_id` VARCHAR(20) NOT NULL COMMENT '群ID';
ALTER TABLE im_group MODIFY COLUMN `group_name` VARCHAR(50) NULL COMMENT '群名字';
ALTER TABLE im_group MODIFY COLUMN `avatar` VARCHAR(200) NULL COMMENT '群头像';
ALTER TABLE im_group MODIFY COLUMN `user_id` VARCHAR(20) NULL COMMENT '群主ID';
ALTER TABLE im_group MODIFY COLUMN `notice` VARCHAR(200) NULL COMMENT '群公告';

ALTER TABLE im_group_user COMMENT = '群成员'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_group_user MODIFY COLUMN `group_id` VARCHAR(20) NOT NULL COMMENT '群ID';
ALTER TABLE im_group_user MODIFY COLUMN `user_id` VARCHAR(20) NOT NULL COMMENT '用户ID';
ALTER TABLE im_group_user MODIFY COLUMN `nick_name` VARCHAR(40) NULL COMMENT '昵称';

ALTER TABLE im_user COMMENT = '用户表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE im_user MODIFY COLUMN `user_id` VARCHAR(20) NOT NULL COMMENT '用户ID';
ALTER TABLE im_user MODIFY COLUMN `user_name` VARCHAR(40) NULL COMMENT '用户姓名';
ALTER TABLE im_user MODIFY COLUMN `account` VARCHAR(40) NULL COMMENT '用户账户';
ALTER TABLE im_user MODIFY COLUMN `password` VARCHAR(20) NULL COMMENT '用户密码';
ALTER TABLE im_user MODIFY COLUMN `avatar` VARCHAR(200) NULL COMMENT '头像';
ALTER TABLE im_user MODIFY COLUMN `sign` VARCHAR(100) NULL COMMENT '签名';
