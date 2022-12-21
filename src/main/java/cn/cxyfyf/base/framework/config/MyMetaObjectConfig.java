package cn.cxyfyf.base.framework.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.SneakyThrows;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectConfig implements MetaObjectHandler {

    public static final String COMMON_FIELD_CREATE_TIME = "createTime";

    public static final String COMMON_FIELD_CREATE_BY = "createBy";

    public static final String COMMON_FIELD_UPDATE_TIME = "updateTime";

    public static final String COMMON_FIELD_UPDATE_BY = "updateBy";

    @SneakyThrows
    @Override
    public void insertFill(MetaObject metaObject) {
        Object fieldValue = getFieldValByName(COMMON_FIELD_CREATE_TIME, metaObject);
        if (fieldValue == null){
            this.setFieldValByName(COMMON_FIELD_CREATE_TIME, LocalDateTime.now(), metaObject);
        }
    }

    @SneakyThrows
    @Override
    public void updateFill(MetaObject metaObject) {
        Object fieldValue = getFieldValByName(COMMON_FIELD_UPDATE_TIME, metaObject);
        if (fieldValue == null){
            this.setFieldValByName(COMMON_FIELD_UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
    }
}

