package Tests.spring_test.spring_aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by iantaman on 06.11.2015.
 */
public class AfterMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("AfterMethod!");
    }
}
