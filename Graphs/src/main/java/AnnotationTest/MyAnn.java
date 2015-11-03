package main.java.AnnotationTest;

/**
 * Created by iantaman on 03.11.2015.
 */
public @interface MyAnn {
    public String title() default "dfvd"; //мы задали параметр

    public  String value() default "sdcs";

    public int version() default 1;

    public int []m() default {1,3,4}; //может быть только одномерным
}
