package com.roilka.common.exception;

import java.io.Serializable;

import com.roilka.common.enums.ErrorCodeEnum;


/**
 * 
* 类名: BaseException.java
* 包名 : com.roilka.common.exception
* 详细描述: 自定义异常类
* 开发人员： zhanghui1
* 开发日期：2018年10月11日 下午9:12:25
*
 */
public class BaseException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 2728936692069322518L;

    private ErrorCodeEnum     errorCode;

    private String            errorMessage;
    
    public BaseException() {
    	super(ErrorCodeEnum.SYSTEM_ERROR.getDesc());
        this.errorCode = ErrorCodeEnum.SYSTEM_ERROR;
        this.errorMessage = errorCode.getDesc();
        
    }

	public BaseException(ErrorCodeEnum errorCode) {
		super(errorCode.getDesc());
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDesc();
    }

	public BaseException(ErrorCodeEnum errorCode, String errorMessage) {
		super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

	public BaseException(ErrorCodeEnum errorCode, String errorMessage, Throwable exception) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        super.initCause(exception);
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
