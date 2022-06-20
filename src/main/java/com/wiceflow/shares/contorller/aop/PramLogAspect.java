package com.wiceflow.shares.contorller.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author BF
 * @date 2022/6/20
 *
 * 参数切面，暂时没生效，还需要看看为什么
 */
@Component
@Slf4j
@Aspect
public class PramLogAspect {
    @Pointcut("execution(public * com.wiceflow.shares.contorller.*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //参数
        Object[] args = joinPoint.getArgs();
        //获取被切参数名称及参数值
        Map<String, Object> nameAndArgs = getFieldsName(clazz, clazzName, methodName, args);
        log.info("进行了 {} 操作,其参数为：{}",methodName,nameAndArgs.toString());
    }

    @After("pointCut()")
    public void doAfter() {

    }


    private Map<String, Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (Objects.equals(method.getName(), methodName)) {
                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    map.put(parameter.getName(), args[i]);
                }
                break;
            }
        }
        return map;
    }
}
