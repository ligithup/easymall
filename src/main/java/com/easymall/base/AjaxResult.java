package com.easymall.base;

import com.easymall.constants.Constants;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * ajax返回结果对象
 *
 */
@JacksonStdImpl
public class AjaxResult implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 成功标识：true/false
     */
	 @ApiModelProperty(value = "是否成功")
    private boolean success = false;

    /**
     * 提示信息
     */
	 @ApiModelProperty(value = "提示信息")
    private String msg = "";

    /**
     * 数据对象
     */
	@ApiModelProperty(value = "数据对象")
    private Object data = null;

    @ApiModelProperty(value = "返回编码")
    private String code = "1";




    /**
     * 设置成功标识：true/false
     *
     * @param success boolean类型
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 设置提示信息
     *
     * @param msg string类型
     *
     *
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 设置返回数据对象
     *
     * @param data object对象
     *
     *
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 信息操作成功
     *
     * @return
     */
    public static AjaxResult success() {
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setCode(Constants.MSG_SUCCESS_CODE);
        result.setMsg(Constants.MSG_SUCCESS);
        return result;
    }

    /**
     * 信息操作成功
     *
     * @return
     */
    public static AjaxResult success(Object data) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setCode(Constants.MSG_SUCCESS_CODE);
        result.setData(data);
        result.setMsg(Constants.MSG_SUCCESS);
        return result;
    }

    /**
     * 信息操作成功
     *
     * @return
     */
    public static AjaxResult success(Object data, String msg) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setCode(Constants.MSG_SUCCESS_CODE);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
    /**
     * 信息保存成功
     *
     * @return
     */
    public static AjaxResult saveSuccess() {
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setCode(Constants.MSG_SUCCESS_CODE);
        result.setMsg(Constants.MSG_SUCCESS_SAVE);
        return result;
    }

    /**
     * 信息保存成功
     *
     * @return
     */
    public static AjaxResult updateSuccess() {
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setCode(Constants.MSG_SUCCESS_CODE);
        result.setMsg(Constants.MSG_SUCCESS_UPDATE);
        return result;
    }

    /**
     * 信息删除成功
     *
     * @return
     */
    public static AjaxResult deleteSuccess() {
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setCode(Constants.MSG_SUCCESS_CODE);
        result.setMsg(Constants.MSG_SUCCESS_DELETE);
        return result;
    }

    /**
     * 处理失败
     *
     * @return
     */
    public static AjaxResult failure() {
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(Constants.MSG_ERROR_CODE);
        return result;
    }

    /**
     * 处理失败
     *
     * @param msg 失败消息
     * @return
     */
    public static AjaxResult failure(String msg) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(Constants.MSG_ERROR_CODE);
        result.setMsg(msg);
        return result;
    }

    /**
     * 处理失败
     *
     * @param msg 失败消息
     * @param data 数据
     * @return
     */
    public static AjaxResult failure(String msg, Object data) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setMsg(msg);
        result.setCode(Constants.MSG_ERROR_CODE);
        result.setData(data);
        return result;
    }


    public boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
