package com.itcast.zwd.springboot.springbootaoplog.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.zwd.springboot.springbootaoplog.annotation.LogAnnotation;
import com.itcast.zwd.springboot.springbootaoplog.entity.SysLog;
import com.itcast.zwd.springboot.springbootaoplog.mapper.SysLogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 随风逐梦
 * @create 2019-11-13 11:43
 */
@Aspect
@Component
public class LogAspect {

    private static  final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private SysLogMapper sysLogMapper;

    @Autowired
    private ObjectMapper objectMapper;



    //定义切点   发生的时机
    @Pointcut("@annotation(com.itcast.zwd.springboot.springbootaoplog.annotation.LogAnnotation)")
    public void logPointCut(){}


    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis() - start;
        saveLog(joinPoint,end);
        return proceed;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long end) {
        log.info("开始触发-保存操作日志");
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        SysLog sysLog = new SysLog();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        if(annotation !=null){
            sysLog.setOperation(annotation.value());
        }

        //获取操作方法名
        String className = joinPoint.getTarget().getClass().getName();
        String name = methodSignature.getName();
        sysLog.setMethod(className+"."+name+"()");

        //获取请求参数
        Object[] args = joinPoint.getArgs();
        try {
            sysLog.setParams(objectMapper.writeValueAsString(args[0]));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sysLog.setTime(end);
        sysLog.setCreateDate(DateTime.now().toDate());
        sysLog.setUsername("zwd");
        sysLog.setIp("localhost");
        sysLogMapper.insertSelective(sysLog);
    }


}
