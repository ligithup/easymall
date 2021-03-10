package com.easymall.page;

import com.easymall.constants.Constants;
import com.easymall.util.ServletUtils;

/**
 * 表格数据处理
 *
 * @author
 */
public class TableSupport
{
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        Integer pageNum =  ServletUtils.getParameterToInt(Constants.PAGE_NUM);
        if(pageNum == null) {
        	pageNum = 1;
        }
        pageDomain.setPageNum(pageNum);
        Integer pageSize = ServletUtils.getParameterToInt(Constants.PAGE_SIZE);
        if(pageSize == null || pageSize>5000) {
        	pageSize = 10;
        }
        pageDomain.setPageSize(pageSize);
        pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
