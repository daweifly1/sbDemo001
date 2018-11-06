<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${namespace}">
    <resultMap id="BaseResultMap" type="${type}">
    <#list propertiesList as p>
        <#if p.column== "id">
            <id column="id" property="id" jdbcType="BIGINT"/>
        <#else>
            <result column="${p.column}" property="${p.property}" jdbcType="${p.jdbcType}"/>
        </#if>
    </#list>
    </resultMap>


    <sql id="Base_Column_List">
    <#list propertiesList as p><#if p.column== "id">id<#else>,${p.column}</#if></#list>
    </sql>

    <sql id="cond">
        <where>
            <if test="id != null">
                and id = ${r'#{id}'}
            </if>
        </where>
    </sql>


    <select id="listPage" resultMap="BaseResultMap" parameterType="XXXXX ${beanName}Form">
        select
        <include refid="Base_Column_List"/>
        from `${tableName}`
        <include refid="cond"/>
        <if test="searchOrder == null or searchOrder == '' ">
            order by id desc
        </if>
        <if test="searchOrder !=null and searchOrder !='' ">
        ${r'${searchOrder}'}
        </if>
        <if test="paging == true">
            limit ${r'#{start}'},${r'#{limit}'}
        </if>
    </select>

    <select id="count" resultType="java.lang.Integer"
            parameterType="XXXXX ${beanName}Form">
        select count(*) from `${tableName}`
        <include refid="cond"/>
    </select>


    <delete id="deleteByPrimaryKeySelective" parameterType="java.lang.Long">
        delete from `${tableName}` where id = ${r'#{id}'}
    </delete>

    <insert id="insert" parameterType="${type}">
        insert into `${tableName}` (id<#list propertiesList as p><#if p.column== "id"><#else>,${p.column}</#if></#list>
        )
        values (seq<#list propertiesList as p><#if p.column== "id"><#else>,${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}</#if></#list>)
    </insert>

    <insert id="batchInsertEdit" parameterType="java.util.List" useGeneratedKeys="true" keyProperty="id">
        insert into `${tableName}` (
        id<#list propertiesList as p><#if p.column== "id"><#else>,${p.column}</#if></#list>
        )
        values
        <foreach collection="list" item="item" index="index" separator=",">
            (
            seq<#list propertiesList as p><#if p.column== "id"><#else>,${r'#{item.'}${p.property},jdbcType=${p.jdbcType}${r'}'}</#if></#list>
            )
        </foreach>
    </insert>


    <update id="updateByPrimaryKeySelective"
            parameterType="${type}">
        update `${tableName}`
        <set>
        <#list propertiesList as p><#if p.column== "id"><#else>
            <if test="${p.property} != null">
            ${p.column} =${r'#{'}${p.property},jdbcType=${p.jdbcType}},
            </if>
        </#if></#list>
        </set>
        where id =  ${r'#{id}'}
    </update>


    <!--建表SQL-->
    CREATE TABLE `${tableName}` (
    `id` bigint(20) NOT NULL COMMENT '主键',
    <#list propertiesList as p>
        <#if p.column== "id">
        <#elseif  p.column== "db_create_author">
        <#elseif  p.column== "db_create_time">
        <#elseif  p.column== "db_update_author">
        <#elseif  p.column== "db_update_time">
        <#else>
            `${p.column}`  <#if p.jdbcType=="VARCHAR" > varchar(${p.length}) <#elseif p.jdbcType=="INTEGER">
            int(10) <#elseif p.jdbcType=="BIGINT">bigint(20) <#elseif p.jdbcType=="TIMESTAMP">
            timestamp   </#if> <#if p.nullAble>NULL <#else> NOT NULL</#if> COMMENT '${p.comment}',
        </#if>
    </#list>
    `db_create_author` varchar(64) DEFAULT NULL COMMENT '操作人',
    `db_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `db_update_author` varchar(64) DEFAULT NULL COMMENT '编辑人',
    `db_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='表注释' /* BF=id,POLICY=activity_multi,STARTID=1, ASSIGNIDTYPE=USB*/;

</mapper>