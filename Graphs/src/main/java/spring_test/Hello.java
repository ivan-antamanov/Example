package spring_test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by iantaman on 05.11.2015.
 */
public class Hello {
    private String s;

    public Hello(String s) {
        this.s = s;
    }

    public void sayHi(){
        System.out.println(s);
    }

    public static void main(String[] args) {
//        Hello h = new Hello("Hi!!!");
//        h.sayHi();

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(new String[] {"config.xml"});
        Hello h = (Hello) applicationContext.getBean("hello");//указываем id нашего bean-а
        h.sayHi();
    }
}
