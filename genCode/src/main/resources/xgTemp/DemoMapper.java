package ${mapperPackageName};

import com.bkwin.jt.dao.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yb.ecp.fast.infra.infra.PageCommonVO;
import yb.ecp.fast.infra.infra.SearchCommonVO;
import java.util.List;
import ${type}
import ${voType}
/**
 * ${tableComment} Mapper
 */
@Mapper
public interface ${beanName}Mapper  extends BaseMapper<${beanName}VO, ${beanName}DO> {

    PageCommonVO list(SearchCommonVO<${beanName}VO> condition);

    List<${beanName}DO> queryList(${beanName}VO condition);

    int insert(${beanName}DO model);

    int merge(${beanName}DO model);

    int updateByPrimaryKeySelective(${beanName}DO bean);

    int deleteByPrimaryKeySelective(String id);

    List<${beanName}DO> queryListByIds(@Param(value = "ids") List<String> ids);

}
