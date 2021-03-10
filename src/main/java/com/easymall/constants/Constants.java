package com.easymall.constants;

/**
 *
 */

public class Constants {

	/********************************* 操作信息常量 ***********************************/
	/**
	 * 成功提示
	 **/
	public static final String MSG_SUCCESS = "信息操作成功!";

	public static final String MSG_SUCCESS_CODE= "1";
	public static final String MSG_ERROR_CODE= "-1";

	/**
	 * 保存成功提示
	 **/
	public static final String MSG_SUCCESS_SAVE = "信息添加成功!";

	/**
	 * 修改成功提示
	 **/
	public static final String MSG_SUCCESS_UPDATE = "信息修改成功!";

	/**
	 * 删除成功提示
	 **/
	public static final String MSG_SUCCESS_DELETE = "信息删除成功!";

	/**
	 * 操作失败提示
	 **/
	public static final String MSG_ERROR = "服务器异常，操作失败!";

	/**
	 * 删除失败提示
	 **/
	public static final String MSG_ERROR_DELETE = "该节点含有子节点";


	  /**
     * 当前记录起始索引
     */
    public static String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static String IS_ASC = "isAsc";

    /**
     * request_limit_log,状态正常
     */
    public static String REQUEST_LIMIT_LOG_SUCCESS = "0";

    /**
     * request_limit_log,状态异常
     */
    public static String REQUEST_LIMIT_LOG_ERROR = "1";

    /**
     * sys_logininfor,登录成功
     */
    public static String SYS_LOGIN_INFO_SUCCESS = "0";

    /**
     * sys_logininfor,登录失败
     */
    public static String SYS_LOGIN_INFO_ERROR = "1";


}
