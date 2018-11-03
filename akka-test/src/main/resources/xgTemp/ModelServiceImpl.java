package ${packageName};

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import yb.ecp.fast.infra.infra.PageCommonVO;
import yb.ecp.fast.infra.infra.SearchCommonVO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ${type}
import ${voType}

import javax.annotation.PostConstruct;

/**
 * ${beanName} 后台接口实现类
 */
@Service
public class ${beanName}Service  extends BaseService<${beanName}VO, ${beanName}DO> {


        private static final Logger logger = LoggerFactory.getLogger(${beanName}Service.class);


        @Autowired
        private ${beanName}Mapper ${beanName}Mapper;

        @PostConstruct
        public void init() {
                super.addMapper(refundMapper);
        }

        protected ${beanName}Service() {
                super(${beanName}VO.class, ${beanName}DO.class);
        }

        /**
         * 查询列表
         *
         * @param form
         */
        public PageCommonVO<${beanName}VO> list(SearchCommonVO<${beanName}VO> condition) {
                if (null == condition.getFilters()) {
                        condition.setFilters(new ${beanName}VO());
                }
                return super.list(condition);
        }

        /**
         * 查询列表
         *
         * @param form
         */
        public List<${beanName}DO> queryList(${beanName}VO vo) {
                return ${beanName}Mapper.queryList(vo);
        }


        /**
         * 查询单条记录
         *
         * @param id
         */
        public ${beanName}DO queryById(String id) {
                ${beanName}VO vo=new ${beanName}VO();
                vo.setId(id);
                List<${beanName}DO> list=queryList(vo);
                if (CollectionUtils.isNotEmpty(list)) {
                        return list.get(0);
                }
                return null;
        }

        /**
         * 保存数据
         *
         * @param dto
         */
        @Transactional(rollbackFor = Exception.class)
        public int merge(${beanName}DO dto) {
                return ${beanName}Mapper.merge(dto);
        }

        /**
         * 批量删除
         *
         * @param ids
         */
        @Transactional(rollbackFor = Exception.class)
        public int batchDelete(List<String> ids) {
            if (CollectionUtils.isEmpty(ids){
                return 0;
            }
            int i=0;
            for(String id:ids){
              i =+ ${beanName}Mapper.deleteByPrimaryKeySelective(id);
            }
            return i;
        }
}
