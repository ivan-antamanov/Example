package main.java.AnnotationTest;

/**
 * Created by iantaman on 03.11.2015.
 */
@MyAnn(title = "sdsds", value = "ffdfsfs", version=3)
@Ann(ann=@MyAnn("scsdcsdc"),anns = {@MyAnn(),@MyAnn()})
public class A {


}
@interface Colored {
    public enum Color {RED, GREEN, BLUE}
    Color value();
}
