package Tests.spring_test.spring_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

/**
 * Created by iantaman on 06.11.2015.
 */
public class AroundMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Method name : "
                + methodInvocation.getMethod().getName());
        System.out.println("Method arguments : "
                + Arrays.toString(methodInvocation.getArguments()));

        // �� ������
        System.out.println("AroundMethod : ������ BeforeMethod!");

        try {
            // ��������� ������������ �����
            Object result = methodInvocation.proceed();

            // ����� ������
            System.out.println("AroundMethod : ������ AfterMethod!");

            return result;

        } catch (IllegalArgumentException e) {
            // ���� ��� ������ ����������
            System.out
                    .println("AroundMethod : ������ ThrowMethod!");
            throw e;
        }
    }
}
