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
        <#list propertiesList as p><#if p_index==0>${p.column}<#elseif (p_index%13==12 && propertiesList?size>13)>,${p.column},<#elseif (p_index%13==12 && propertiesList?size==13)>${p.column}<#elseif p_index%13==0>
        ${p.column}<#else >,${p.column}</#if></#list>
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

    <select id="list" parameterType="${voType}" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        <include refid="cond"/>
    </select>

    <select id="queryList" parameterType="${voType}" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        <include refid="cond"/>
    </select>


    <delete id="deleteByPrimaryKeySelective" parameterType="java.lang.String">
        delete from ${tableName} where ID = ${r'#{id,jdbcType=VARCHAR}'}
    </delete>

    <insert id="insert" parameterType="${type}">
        insert into ${tableName} (
        <#list propertiesList as p><#if p_index==0>${p.column}<#elseif (p_index%13==12 && propertiesList?size>13)>,${p.column},<#elseif (p_index%13==12 && propertiesList?size==13)>${p.column}<#elseif p_index%13==0>
        ${p.column}<#else >,${p.column}</#if></#list>
        )
        values (
         <#list propertiesList as p><#if p_index==0>${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}<#elseif (p_index%5==4 && propertiesList?size>5)>,${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'},<#elseif (p_index%5==4 && propertiesList?size==5)>${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}<#elseif p_index%5==0>
         ${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}<#else >,${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}</#if></#list>
    </insert>

    <update id="merge" parameterType="${type}">
        merge into ${tableName} t1
        using (select ${r'#{id,jdbcType=VARCHAR}'} as ID from dual)tab_
        ON (t1.ID=tab_.ID)
        WHEN MATCHED THEN
        update
        <set>
        <#list propertiesList as p><#if p.column== "ID"><#else>
            <if test="${p.property} != null">
                ${p.column} =${r'#{'}${p.property},jdbcType=${p.jdbcType}},
            </if>
        </#if></#list>
        </set>
        WHEN NOT MATCHED THEN
        insert  (
        <#list propertiesList as p><#if p_index==0>${p.column}<#elseif (p_index%13==12 && propertiesList?size>13)>,${p.column},<#elseif (p_index%13==12 && propertiesList?size==13)>${p.column}<#elseif p_index%13==0>
        ${p.column}<#else >,${p.column}</#if></#list>
        )
        values (
        <#list propertiesList as p><#if p_index==0>${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}<#elseif (p_index%5==4 && propertiesList?size>5)>,${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'},<#elseif (p_index%5==4 && propertiesList?size==5)>${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}<#elseif p_index%5==0>
        ${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}<#else >,${r'#{'}${p.property},jdbcType=${p.jdbcType}${r'}'}</#if></#list>
        )
    </update>

    <update id="updateByPrimaryKeySelective" parameterType="${type}">
        update ${tableName}
        <set>
        <#list propertiesList as p><#if p.column== "ID"><#else>
            <if test="${p.property} != null">
                ${p.column} =${r'#{'}${p.property},jdbcType=${p.jdbcType}},
            </if>
        </#if></#list>
        </set>
        where ID =  ${r'#{id,jdbcType=VARCHAR}'}
    </update>
</mapper>