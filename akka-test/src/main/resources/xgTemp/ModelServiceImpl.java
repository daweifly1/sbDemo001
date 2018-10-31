package ${packageName};

import org.springframework.beans.factory.annotation.Autowired;

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
public class ${beanName}Service {


        private static final Logger logger = LoggerFactory.getLogger(${beanName}Service.class);


        @Autowired
        private ${beanName}Mapper ${beanName}Mapper;

        /**
         * 查询列表
         *
         * @param form
         */
        public List<${beanName}> queryList(${beanName}Form form) {
            return null;
        }


        /**
         * 查询单条记录
         *
         * @param id
         */
        public ${beanName} queryById(Long id) {
            return null;
        }

        /**
         * 保存数据
         *
         * @param dto
         */
        @Override
        public Long save${beanName}(${beanName} dto) {
            return null;
        }

        /**
         * 批量删除
         *
         * @param ids
         */
        public Integer batchDelete(List<Long> ids) {
            return null;
        }
}
