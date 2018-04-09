package ${packageName};
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public interface ${beanName} {
    <#list propertiesList as p>
        <#if p.column== "id">private Long id;
        <#elseif p.jdbcType=="BIGINT">private Long ${p.property};
        <#elseif p.jdbcType=="TIMESTAMP">private Date ${p.property};
        <#elseif p.jdbcType=="VARCHAR">private String ${p.property};
        <#else>  private Object ${p.property};
        </#if>
    </#list>
}
