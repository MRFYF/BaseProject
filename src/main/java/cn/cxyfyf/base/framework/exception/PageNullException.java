package cn.cxyfyf.base.framework.exception;

/**
 * 全局分页异常
 * @author fengyingfeng
 */
public class PageNullException extends RuntimeException{

    private static final long serialVersionUID = -5817297416850766683L;

    public PageNullException(Throwable e) {
        super(e.getMessage(), e);
    }

    public PageNullException(String message) {
        super(message);
    }
}
