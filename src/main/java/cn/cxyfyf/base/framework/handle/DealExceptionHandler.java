package cn.cxyfyf.base.framework.handle;

import cn.cxyfyf.base.framework.exception.FieldException;
import cn.cxyfyf.base.framework.exception.PageNullException;
import cn.cxyfyf.base.framework.web.domain.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常监听
 * @author fengyingfeng
 */
@ControllerAdvice
public class DealExceptionHandler {

    /**
     * 抛出分页异常
     * @param ex 异常
     * @return 抛出异常信息
     */
    @ExceptionHandler(PageNullException.class)
    @ResponseBody//为了返回数据
    public AjaxResult pageNullExceptionHandler(Exception ex) {
        ex.printStackTrace();
        return AjaxResult.error(ex.getMessage());
    }

    /**
     * 抛出字段异常
     * @param ex 异常
     * @return 抛出异常信息
     */
    @ExceptionHandler(FieldException.class)
    @ResponseBody//为了返回数据
    public AjaxResult fieldExceptionHandler(Exception ex) {
        ex.printStackTrace();
        return AjaxResult.error(ex.getMessage());
    }
}
