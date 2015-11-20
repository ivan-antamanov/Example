package Tests.spring_test.spring_aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by iantaman on 06.11.2015.
 */
public class ThrowException implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("ThrowException!");
    }
}
