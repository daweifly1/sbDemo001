package ${packageName};
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class ${beanName}  implements Serializable{
    <#list propertiesList as p>
        <#if p.column== "id">private Long id;
        <#elseif p.javaType=="BIGINT">private Long ${p.property};
        <#elseif p.javaType=="INTEGER">private Integer ${p.property};
        <#elseif p.javaType=="Short">private Short ${p.property};
        <#elseif p.javaType=="DECIMAL">private Integer ${p.property};
        <#elseif p.javaType=="Date">private Date ${p.property};
        <#elseif p.javaType=="String">private String ${p.property};
        <#else>  private ${p.javaType} ${p.property};
        </#if>
    </#list>
}
