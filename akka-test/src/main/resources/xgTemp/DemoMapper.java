package ${packageName};

import com.bkwin.jt.dao.mapper.BaseMapper;
import com.bkwin.jt.service.vo.refund.RefundVO;
import org.apache.ibatis.annotations.Mapper;
import yb.ecp.fast.infra.infra.PageCommonVO;
import yb.ecp.fast.infra.infra.SearchCommonVO;
import ${type}
import ${voType}
/**
 * ${tableComment} Mapper
 */
@Mapper
public interface ${beanName}Mapper  extends BaseMapper<RefundVO, RefundDO> {

    PageCommonVO list(SearchCommonVO<${beanName}VO> condition);

    List<${beanName}DO> queryList(${beanName}VO condition);

    int insert(${beanName}DO model);

    int merge(${beanName}DO model);

    int updateByPrimaryKeySelective(${beanName}DO bean);

    int deleteByPrimaryKeySelective(String id);
}
