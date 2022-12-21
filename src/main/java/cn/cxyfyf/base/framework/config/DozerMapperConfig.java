package cn.cxyfyf.base.framework.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 * dozer 配置
 * @author fengyingfeng
 * Create by 2022/12/7 15:22
 */
@Configuration
public class DozerMapperConfig {

    @Bean(name = "org.dozer.Mapper")
    public Mapper mapper(){
        //如果要读取多个或者一个xml文件，则将写进下面地址,如果不需要xml配置则不用。
        // mapper.setMappingFiles(Arrays.asList("dozer/dozer-mapping.xml","dozer/xxx.xml"));
        return new DozerBeanMapper();
    }
}
