/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacRole.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.devi.test.hibernate.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
//import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * The class Uac role.
 *
 * @author paascloud.net@gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "pc_uac_role")
//@Alias(value = "uacRole")
public class UacRole extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -6049575043793281879L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 版本号
	 */
	@Column(name = "version")
	private Integer version;
	/**
	 * 创建人
	 */
	@Column(name = "creator")
	private String creator;

	/**
	 * 创建人ID
	 */
	@Column(name = "creator_id")
	private Long creatorId;

	/**
	 * 创建时间
	 */
	@Column(name = "created_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdTime;

	/**
	 * 最近操作人
	 */
	@Column(name = "last_operator")
	private String lastOperator;

	/**
	 * 最后操作人ID
	 */
	@Column(name = "last_operator_id")
	private Long lastOperatorId;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 角色编码
	 */
	@Column(name = "role_code")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "{role.roleCode.pattern}")
	@Length(min = 6, max = 20, message = "{role.roleCode.length}")
	private String roleCode;

	/**
	 * 角色名称
	 */
	@Column(name = "role_name")
	@Pattern(regexp = "^[\\u4e00-\\u9faf]+$", message = "{role.roleName.pattern}")
	@Length(min = 4, max = 10, message = "{role.roleName.length}")
	private String roleName;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 备注
	 */
	@Length(max = 150, message = "{role.remark.length}")
	private String remark;
}
