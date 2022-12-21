package cn.cxyfyf.base.framework.exception;

/**
 * 全局字段异常
 * @author fengyingfeng
 */
public class FieldException extends RuntimeException{

    private static final long serialVersionUID = -3169994179175953751L;

    public FieldException(Throwable e) {
        super(e.getMessage(), e);
    }

    public FieldException(String message) {
        super("字段校验：" + message);
    }
}
