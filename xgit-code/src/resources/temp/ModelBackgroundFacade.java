package ${packageName};

import com.netease.haitao.common.response.Response;
import com.netease.haitao.matter.param.babyplan.BabyArticleConfigParam;
import com.netease.haitao.matter.result.babyplan.BabyArticleConfigDto;
import com.netease.haitao.matter.result.base.PageResult;

/**
 * ${beanName} 后台接口
 */
public interface ${beanName}BackgroundFacade{

        /**
         * 分页数据查询
         *
         * @param param
         * @return
         */
        Response<PageResult<${beanName}Dto>> queryPageList(${beanName}Param param);

        /**
         * 查询列表
         *
         * @param param
         * @return
         */
        Response<List<${beanName}Dto>> queryList(${beanName}Param param);


        /**
         * 查询单条记录
         *
         * @param id
         * @return
         */
        Response<${beanName}Dto> queryById(Long id);


        /**
         * 保存数据
         *
         * @param dto
         * @return
         */
        Response<Long> save${beanName}(${beanName}Dto dto);

        /**
         * 批量删除
         *
         * @param ids
         * @return
         */
        Response<Integer> batchDelete(List<Long> ids);
}
