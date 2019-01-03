package ${voPackageName};
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
/**
 * ${tableComment} VO类
 */
@Data
@ToString
public class ${beanName}VO  implements Serializable{
    private static final long serialVersionUID = -1L;
<#list propertiesList as p>
    @ApiModelProperty(value = "${p.comment}"<#if p.required>, required = true</#if>  )
    private ${p.javaType} ${p.property};
</#list>
}
