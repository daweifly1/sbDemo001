package ${packageName};
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class ${beanName}Form  implements Serializable{
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
     * 排序内容
     */
    private String searchOrder;

    /**
     * 起始位置
     */
    private int start;

    private int limit;

    /**
     * 是否分页查询
     */
    private boolean paging;
}
