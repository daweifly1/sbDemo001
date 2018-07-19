package $

import org.springframework.beans.factory.annotation.Autowired;{packageName};

import org.springframework.stereotype.Service;
import com.netease.haitao.common.response.Response;
import com.netease.haitao.matter.result.base.PageResult;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * ${beanName} 后台接口实现类
 */
@Service
public class ${beanName}BackgroundFacadeImpl  implements ${beanName}BackgroundFacade {


        private static final Logger logger = LoggerFactory.getLogger(${beanName}BackgroundFacadeImpl.class);


        @Autowired
        private ${beanName}Service ${beanName}Service;

        @Autowired
        private RedisClient redisClient;

        /**
         * 分页数据查询
         *
         * @param param
         */
        @Override
        public  Response<PageResult<${beanName}Dto>> queryPageList(${beanName}Param param) {
            return null;
        }

        /**
         * 查询列表
         *
         * @param param
         */
        @Override
        public Response<List<${beanName}Dto>> queryList(${beanName}Param param) {
            return null;
        }


        /**
         * 查询单条记录
         *
         * @param id
         */
        @Override
        public Response<${beanName}Dto> queryById(Long id) {
            return null;
        }

        /**
         * 保存数据
         *
         * @param dto
         */
        @Override
        public Response<Long> save${beanName}(${beanName}Dto dto) {
            return null;
        }

        /**
         * 批量删除
         *
         * @param ids
         */
        @Override
        public Response<Integer> batchDelete(List<Long> ids) {
            return null;
        }
}
