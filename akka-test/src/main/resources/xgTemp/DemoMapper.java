package ${packageName};

/**
 * ${tableComment} Mapper
 */
public interface ${beanName}Mapper {

    PageCommonVO list(SearchCommonVO<${beanName}> condition)

    List<${beanName}> queryList(SearchCommonVO<${beanName}> condition);

    int insert(${beanName} model);

    int updateByPrimaryKeySelective(${beanName} bean);

    int deleteByPrimaryKeySelective(String id);
}
