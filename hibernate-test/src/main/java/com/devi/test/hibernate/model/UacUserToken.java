package com.devi.test.hibernate.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
//import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * The class Uac user token.
 *
 * @author paascloud.net @gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
//@Alias(value = "uacUserToken")
@Table(name = "pc_uac_user_token")
public class UacUserToken extends BaseEntity {
	private static final long serialVersionUID = 4341237600124353997L;
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
	 * 父ID
	 */
	private Long pid;

	/**
	 * 登录名
	 */
	@Column(name = "login_name")
	private String loginName;

	/**
	 * 姓名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 用户ID
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 登陆人Ip地址
	 */
	@Column(name = "login_ip")
	private String loginIp;

	/**
	 * 登录地址
	 */
	@Column(name = "login_location")
	private String loginLocation;

	/**
	 * 登录地址
	 */
	@Column(name = "login_time")
	private Date loginTime;

	/**
	 * 操作系统
	 */
	private String os;

	/**
	 * 浏览器类型
	 */
	private String browser;

	/**
	 * 访问token
	 */
	@Column(name = "access_token")
	private String accessToken;

	/**
	 * 刷新token
	 */
	@Column(name = "refresh_token")
	private String refreshToken;

	/**
	 * 访问token的生效时间(秒)
	 */
	@Column(name = "access_token_validity")
	private Integer accessTokenValidity;

	/**
	 * 刷新token的生效时间(秒)
	 */
	@Column(name = "refresh_token_validity")
	private Integer refreshTokenValidity;

	/**
	 * 0 在线 10已刷新 20 离线
	 */
	private Integer status;

	/**
	 * 组织流水号
	 */
	@Column(name = "group_id")
	private Long groupId;

	/**
	 * 组织名称
	 */
	@Column(name = "group_name")
	private String groupName;

	/**
	 * 失效时间(秒)
	 */
	@Transient
	private Integer expiresIn;
}
