package com.atguigu.gmall.admin.config;


import com.atguigu.gmall.to.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
//后台进行统一校验
@Slf4j //日志注解
@Aspect  //说明这是一个切面
@Component //加入到容器中
public class GmallValidatorAspect {


    @Around("execution(* com.atguigu.gmall.admin..controller..*.*(..))")//切入点表达式
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//环绕通知，可以阻止方法
        log.info("校验切面切入进行工作......");
        //proceedingJoinPoint.proceed();
        //xxx.invoke();
        Object[] args = proceedingJoinPoint.getArgs();//定义方法参数
        Object proceed = null;

            //前置通知
            for (Object obj:args) {
                //获取当前所有参数
                if(obj instanceof BindingResult){
                    //只获取感兴趣的BindingResult
                    //判断校验有无错误
                    int count = ((BindingResult) obj).getErrorCount();//getErrorCount()方法获取错误统计
                    if(count > 0){
                        //有错误
                        log.info("校验发生错误。。。直接给用户返回....");
                        CommonResult commonResult = new CommonResult().validateFailed((BindingResult) obj);
                        return commonResult;
                    }
                }
            }
            //方法执行完成  method.invoke();
            proceed = proceedingJoinPoint.proceed(args);//放行方法执行

        //后置通知
        return proceed;
    }
}
