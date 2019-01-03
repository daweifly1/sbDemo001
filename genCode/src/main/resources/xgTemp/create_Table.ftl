  drop TABLE ${tableName};
   <!--"${tableComment}"建表SQL-->
    CREATE TABLE ${tableName} (
        ID VARCHAR2(20) NOT null,
    <#list propertiesList as p>
        <#if p.column== "ID">
        <#elseif  p.column== "CREATE_AUTHOR1">
        <#else>
        ${p.column}  <#if p.jdbcType=="VARCHAR" >VARCHAR2(${p.length}) <#elseif p.jdbcType=="INTEGER">NUMBER(10) <#elseif p.jdbcType=="BIGINT">NUMBER(20) <#elseif p.jdbcType=="TIMESTAMP">TIMESTAMP(6) <#elseif p.jdbcType=="DATE">TIMESTAMP(6)<#elseif p.jdbcType=="DECIMAL">NUMBER(14,3)</#if> <#if p.nullAble>NULL <#else> NOT NULL</#if>,
        </#if>
    </#list>
        constraint PK_${tableName} primary key (ID)
    );
    comment on table ${tableName} is '${tableComment}';
<#list propertiesList as p>
    comment on column ${tableName}.${p.column} is '${p.comment}';
</#list>

   <#list propertiesList as p>

   alter TABLE ${tableName} add(<#if p.column== "ID"><#elseif  p.column== "CREATE_AUTHOR1"><#else>${p.column}  <#if p.jdbcType=="VARCHAR" >VARCHAR2(${p.length}) <#elseif p.jdbcType=="INTEGER">NUMBER(10) <#elseif p.jdbcType=="BIGINT">NUMBER(20) <#elseif p.jdbcType=="TIMESTAMP">TIMESTAMP(6) <#elseif p.jdbcType=="DATE">TIMESTAMP(6)<#elseif p.jdbcType=="DECIMAL">NUMBER(14,3)</#if> <#if p.nullAble>NULL <#else> NOT NULL</#if></#if>);

   </#list>
