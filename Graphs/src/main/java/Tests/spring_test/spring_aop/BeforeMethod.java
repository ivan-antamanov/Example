package Tests.spring_test.spring_aop;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by iantaman on 06.11.2015.
 */
public class BeforeMethod implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o)
            throws Throwable {
        System.out.println("BeforeMethod!");
    }
}

