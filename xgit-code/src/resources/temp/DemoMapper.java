package ${packageName};

public interface ${beanName}Mapper {
    List<${beanName}> query(${beanName}Form form);

    int insert(${beanName} model);

    int updateByPrimaryKeySelective(${beanName} bean);

    int deleteByPrimaryKeySelective(long id);
}
