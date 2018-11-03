package ${packageName};
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

/**
 * ${tableComment} DO
 */
@Data
@ToString
public class ${beanName}DO  implements Serializable{
    <#list propertiesList as p>//${p.comment}
        <#if p.column== "id">private Long id;
        <#elseif p.jdbcType=="BIGINT">private Long ${p.property};
        <#elseif p.jdbcType=="INTEGER">private Integer ${p.property};
        <#elseif p.jdbcType=="TIMESTAMP">private Timestamp ${p.property};
        <#elseif p.jdbcType=="VARCHAR">private String ${p.property};
        <#elseif p.jdbcType=="DECIMAL">private BigDecimal ${p.property};
        <#else>  private Object ${p.property};
        </#if>
    </#list>
}
