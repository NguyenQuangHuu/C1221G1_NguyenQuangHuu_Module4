package vn.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logging {
     int countVisitor = 0;
    @Pointcut("execution(* vn.codegym.controller.BookController.*(..))")
    public void methodLogger(){};

    @After("methodLogger()")
    public void afterLogger(JoinPoint joinPoint){
//        if(joinPoint.getSignature().getName().equals("getAll")){
            System.out.println("Số lần truy cập "+ countVisitor++ +" , vào lúc "+LocalDateTime.now());
//        }
    }

    @Pointcut("execution(* vn.codegym.controller.BookController.*Book(..))")
    public void statusLogger(){}

    @AfterReturning("statusLogger()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("Thao tác thay đổi trạng thái sách : "+joinPoint.getSignature().getName()+ " , vào lúc : "+ LocalDateTime.now());
    }
}
