package ${packageName};
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class ${beanName}Param  implements Serializable{
    <#list propertiesList as p>
        <#if p.column== "id">private Long id;
        <#elseif p.jdbcType=="BIGINT">private Long ${p.property};
        <#elseif p.jdbcType=="INTEGER">private Integer ${p.property};
        <#elseif p.jdbcType=="TIMESTAMP">private Timestamp ${p.property};
        <#elseif p.jdbcType=="VARCHAR">private String ${p.property};
        <#else>  private Object ${p.property};
        </#if>
    </#list>
/**
 * 当前页，1基址
 */
private Integer currentPage = null;
/**
 * 每页记录数
 */
private Integer recordPerPage = null;
/**
 * 总页数
 */
private Integer totalPage = null;
/**
 * 总记录数
 */
private Integer totalRecord = null;
}
