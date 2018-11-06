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
    private static final long serialVersionUID = -1L;
<#list propertiesList as p>
    //${p.comment}<#if p.required>,数据库必填字段</#if><#if p.jdbcType=="BIGINT">
    private Long ${p.property};<#elseif p.jdbcType=="INTEGER">
    private Integer ${p.property};<#elseif p.jdbcType=="TIMESTAMP">
    private Date ${p.property};<#elseif p.jdbcType=="VARCHAR">
    private String ${p.property};<#elseif p.jdbcType=="DECIMAL">
    private BigDecimal ${p.property};<#else>
    private Object ${p.property};</#if>
</#list>

}
