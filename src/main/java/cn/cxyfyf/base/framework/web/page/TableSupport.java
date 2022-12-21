package cn.cxyfyf.base.framework.web.page;

import cn.cxyfyf.base.framework.exception.PageNullException;
import cn.cxyfyf.base.framework.utils.StringUtils;
import cn.cxyfyf.base.framework.utils.ServletUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 表格数据处理
 *
 */
public class TableSupport
{
    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(IS_ASC));
        return pageDomain;
    }
    /**
     * 封装分页对象
     */
    public static<T> Page<T> getPage()
    {
        Page<T> page = new Page<T>();
        Integer pageNum = ServletUtils.getParameterToInt(PAGE_NUM);
        Integer pageSize = ServletUtils.getParameterToInt(PAGE_SIZE);
        if (StringUtils.isNull(pageNum) || StringUtils.isNull(pageSize)){
            throw new PageNullException("分页参数不能为空！");
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return page;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
