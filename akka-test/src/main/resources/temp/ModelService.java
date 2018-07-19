package ${packageName};

import com.netease.haitao.common.response.Response;
import com.netease.haitao.matter.param.babyplan.BabyArticleConfigParam;
import com.netease.haitao.matter.result.babyplan.BabyArticleConfigDto;
import com.netease.haitao.matter.result.base.PageResult;

/**
 * ${beanName} 后台接口
 */
public interface ${beanName}Service{

        /**
         * 查询列表
         *
         * @param form
         * @return
         */
        List<${beanName}> queryList(${beanName}Form form);


        /**
         * 查询单条记录
         *
         * @param id
         * @return
         */
        ${beanName} queryById(Long id);


        /**
         * 保存数据
         *
         * @param dto
         * @return
         */
        Long save${beanName}(${beanName} dto);

        /**
         * 批量删除
         *
         * @param ids
         * @return
         */
        Integer batchDelete(List<Long> ids);
}
