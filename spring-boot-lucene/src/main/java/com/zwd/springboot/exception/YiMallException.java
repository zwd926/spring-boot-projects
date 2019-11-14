package com.zwd.springboot.exception;


import com.zwd.springboot.entity.ResultEnum;

public class YiMallException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ResultEnum resultEnum;
	
	public YiMallException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.resultEnum=resultEnum;
	}

	public ResultEnum getResultEnum() {
		return resultEnum;
	}

}
