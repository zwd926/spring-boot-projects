package com.zwd.springboot.exception;

import com.zwd.springboot.entity.ResultBean;
import com.zwd.springboot.entity.ResultEnum;
import com.zwd.springboot.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 * @author yizl
 * @param <T>
 *
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle<T> {
	
	@ExceptionHandler(value = Exception.class)
	public ResultBean<T> handle(Exception e) {
		if(e instanceof YiMallException) {
			YiMallException yiMallException=(YiMallException) e;
			return ResultUtil.error(yiMallException.getResultEnum());
		}else {
			return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
		}
	}
}
