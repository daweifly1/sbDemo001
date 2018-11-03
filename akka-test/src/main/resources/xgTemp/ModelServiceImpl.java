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
        private ${beanName}Mapper ${fistLowerBeanName}Mapper;

        @PostConstruct
        public void init() {
                super.addMapper(${fistLowerBeanName}Mapper);
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
                PageCommonVO<${beanName}VO> page= super.list(condition);
                //TODO．．．是否需要其他操作完善数据
                return page;
        }

        /**
         * 查询列表
         *
         * @param form
         */
        public List<${beanName}DO> queryList(${beanName}VO vo) {
                return ${fistLowerBeanName}Mapper.queryList(vo);
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
        public ErrorCode save(${beanName}VO ${fistLowerBeanName}VO, String userId, String userName, String orgId) throws Exception {
                //TODO　是否需要前置校验逻辑
                //初始时候数据状态
                int saveStatus=0;
                doSave(${fistLowerBeanName}VO, userId, userName, orgId, false, saveStatus);
                //TODO　是否需要后置操作
                return ErrorCode.Success;
        }

        /**
        * 提交数据
        *
        * @param dto
        */
        @Transactional(rollbackFor = Exception.class)
        public ErrorCode submit(${beanName}VO ${fistLowerBeanName}VO, String userId, String userName, String orgId) throws Exception {
                //TODO　是否需要前置校验逻辑
                //TODO 提交后的时候数据状态
                int saveStatus=1;
                doSave(${fistLowerBeanName}VO, userId, userName, orgId, false, saveStatus);
                //TODO　是否需要后置操作
                return ErrorCode.Success;
        }

        /**
         * 根据状态，等信息保存数据
         *
         * @param dto
         */
        private void doSave(${beanName}VO ${fistLowerBeanName}VO, String userId, String userName, String orgId, boolean isSubmit, int status) throws Exception {
                //TODO 保存是否需要校验？
                preSaveCheck(${fistLowerBeanName}VO, isSubmit,int status);
                ${beanName}DO ${fistLowerBeanName}DO = getDO(${beanName}VO);
                if (StringUtils.isBlank(${fistLowerBeanName}DO.getId())) {
                        ${fistLowerBeanName}DO.setCreateId(userId);
                        ${fistLowerBeanName}DO.setCreateName(userName);
                        ${fistLowerBeanName}DO.setOrgId(orgId);
                        ${fistLowerBeanName}DO.setCreateDate(new Date());
                        ${fistLowerBeanName}DO.setId(genId());
                        //TODO ...其他新增时候需要赋值的记录
                        logger.info("新增操作，${fistLowerBeanName}DO:{}",${fistLowerBeanName}DO);
                } else {
                        logger.info("编辑操作，${fistLowerBeanName}DO:{}", ${fistLowerBeanName}DO);
                        //TODO 之前的记录需要处理？例如删除关联信息
                }
                //TODO 状态处理
                ${fistLowerBeanName}DO.setStatus(status);
                //TODO　关联信息处理
                boolean isSuccess = this.merge(refundDO) > 0;
                if (!isSuccess) {
                        throw new Exception("保存记录失败");
                }
                //TODO　关联信息后置处理。。。
        }
        /**
         * 保存前信息校验
         */
        private void preSaveCheck(${beanName}VO ${fistLowerBeanName}VO, boolean isSubmit,int status) throws Exception {
                if (null == ${fistLowerBeanName}VO) {
                throw new Exception(ErrorCode.IllegalArument.getDesc());
                }
                //TODO如果是提交操作或者某些状态下需要做校验吗？
                //        if (isSubmit&&status？？？) {
                //        }
                //TODO 如果是编辑,需要做的校验 。。。
                if (StringUtils.isNotBlank(${fistLowerBeanName}VO.getId())) {
                }
        }


        @Transactional(rollbackFor = Exception.class)
        public int merge(${beanName}DO dto) {
                return ${fistLowerBeanName}Mapper.merge(dto);
        }

        /**
         * 批量删除
         *
         * @param ids
         */
        @Transactional
        public int batchDelete(List<String> ids) {
            if (CollectionUtils.isEmpty(ids){
                return 0;
            }
            int i=0;
            for(String id:ids){
              i =+ ${fistLowerBeanName}Mapper.deleteByPrimaryKeySelective(id);
            }
            return i;
        }
}
