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
    <#list propertiesList as p><#if p.column== "ID">ID<#else>,${p.column}</#if></#list>
    </sql>

    <sql id="cond">
        <where>
            <if test="id != null">
                and ID = ${r'#{id,jdbcType=VARCHAR}'}
            </if>
<#list propertiesList as p><#if p.column== "ID"><#else>
            <if test="${p.property} != null">
               and  ${p.column} =${r'#{'}${p.property},jdbcType=${p.jdbcType}}
            </if>
</#if></#list>
        </where>
    </sql>

    <select id="list" parameterType="${type}VO" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from `${tableName}`
        <include refid="cond"/>
    </select>

    <select id="queryList" parameterType="${type}VO" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from `${tableName}`
        <include refid="cond"/>
    </select>


    <delete id="deleteByPrimaryKeySelective" parameterType="java.lang.String">
        delete from `${tableName}` where id = ${r'#{id,jdbcType=VARCHAR}'}
    </delete>

    <insert id="insert" parameterType="${type}">
        insert into `${tableName}` (id<#list propertiesList as p><#if p.column== "id"><#else>,${p.column}</#if></#list>
        )
        values (${r'#{item.id,jdbcType=VARCHAR}'},<#list propertiesList as p><#if p.column== "id"><#else>,${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}</#if></#list>)
    </insert>




    <update id="updateByPrimaryKeySelective" parameterType="${type}">
        update `${tableName}`
        <set>
        <#list propertiesList as p><#if p.column== "id"><#else>
            <if test="${p.property} != null">
            ${p.column} =${r'#{'}${p.property},jdbcType=${p.jdbcType}},
            </if>
        </#if></#list>
        </set>
        where ID =  ${r'#{id}'}
    </update>


    <!--建表SQL-->
    CREATE TABLE `${tableName}` (
    `ID` VARCHAR2(20) NOT null,
    <#list propertiesList as p>
        <#if p.column== "ID">
        <#elseif  p.column== "CREATE_AUTHOR1">
        <#else>
            `${p.column}`  <#if p.jdbcType=="VARCHAR" > VARCHAR2(${p.length}) <#elseif p.jdbcType=="INTEGER">
            NUMBER(10) <#elseif p.jdbcType=="BIGINT">NUMBER(20) <#elseif p.jdbcType=="TIMESTAMP">
            DATE</#if> <#if p.nullAble>NULL <#else> NOT NULL</#if>,
        </#if>
    </#list>
    constraint PK_T_WAREHOUSE_INVOICE primary key (ID)
    );

    comment on table `${tableName}` is '${tableComment}';
<#list propertiesList as p>
    comment on column ${p.column} is  '${p.comment}';
</#list>
</mapper>