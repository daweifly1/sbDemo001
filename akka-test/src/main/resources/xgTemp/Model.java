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
    //${p.comment}<#if p.required>,数据库必填字段</#if>
    private ${p.javaType} ${p.property};
</#list>

}
