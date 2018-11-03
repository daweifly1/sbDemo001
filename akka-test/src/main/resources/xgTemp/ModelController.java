package ${packageName};

import com.bkwin.jt.infra.BasicController;
import com.bkwin.jt.infra.ErrorCode;


import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yb.ecp.fast.infra.annotation.FastMappingInfo;
import yb.ecp.fast.infra.infra.ActionResult;
import yb.ecp.fast.infra.infra.PageCommonVO;
import yb.ecp.fast.infra.infra.SearchCommonVO;
import ${type}
import ${voType}
import ****.${fistLowerBeanName}Service;

import javax.annotation.PostConstruct;

/**
 * ${beanName} Controller 实现类
 */
@RestController
@RequestMapping("/${fistLowerBeanName}")
public class ${beanName}Controller extends BasicController {
        private static final Logger logger = LoggerFactory.getLogger(${beanName}Controller.class);
        @Autowired
        private ${beanName}Service ${fistLowerBeanName}Service;

        @RequestMapping(value = "/list", method = RequestMethod.POST)
        @ApiOperation(value = "${tableComment}分页列表信息")
        @FastMappingInfo(needLogin = true)
        public ActionResult<PageInfo<${beanName}VO>> list(@RequestBody SearchCommonVO<${beanName}VO> condition) {
                PageCommonVO<${beanName}VO> pageCommonVO = ${fistLowerBeanName}Service.list(condition);
                return actionResult(pageCommonVO.getPageInfo());
        }


        @RequestMapping(value = "/save", method = RequestMethod.POST)
        @ApiOperation(value = "${tableComment}-保存")
        @FastMappingInfo(needLogin = true)
        public ActionResult<ErrorCode> save(@RequestBody ${beanName}VO ${fistLowerBeanName}VO) {
                if (null == ${fistLowerBeanName}VO) {
                        //TODO　校验逻辑。。
                        return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = ${fistLowerBeanName}Service.save(${fistLowerBeanName}VO, getUserId(), getUserName(), getOrgId());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }

        @RequestMapping(value = "/submit", method = RequestMethod.POST)
        @ApiOperation(value = "${tableComment}-保存")
        @FastMappingInfo(needLogin = true)
        public ActionResult<ErrorCode> submit(@RequestBody ${beanName}VO ${fistLowerBeanName}VO) {
                if (null == ${fistLowerBeanName}VO) {
                //TODO　校验逻辑。。
                return actionResult(ErrorCode.IllegalArument);
                }
                try {
                        ErrorCode code = ${fistLowerBeanName}Service.submit(${fistLowerBeanName}VO, getUserId(), getUserName(), getOrgId());
                        return actionResult(code);
                } catch (Exception e) {
                        return new ActionResult(ErrorCode.Failure.getCode(), e.getMessage());
                }
        }


        @RequestMapping(value = "/item", method = RequestMethod.GET)
        @ApiOperation(value = "根据id查询${tableComment}详情")
        @FastMappingInfo(needLogin = true)
        public ActionResult<${beanName}VO> item(String id) {
                ${beanName}VO ${fistLowerBeanName}VO = ${fistLowerBeanName}Service.item(id);
                return actionResult(${fistLowerBeanName}VO);
        }
}
