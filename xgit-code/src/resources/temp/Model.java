package ${packageName};
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class ${beanName}  implements Serializable{
    <#list propertiesList as p>
        <#if p.column== "id">private Long id;
        <#elseif p.jdbcType=="BIGINT">private Long ${p.property};
        <#elseif p.jdbcType=="INTEGER">private Integer ${p.property};
        <#elseif p.jdbcType=="TIMESTAMP">private Timestamp ${p.property};
        <#elseif p.jdbcType=="VARCHAR">private String ${p.property};
        <#else>  private Object ${p.property};
        </#if>
    </#list>
}
