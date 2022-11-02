package app;


import components.MemberProgram;
import configuration.MemberConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MemberConfiguration.class);
        MemberProgram memberProgram = context.getBean(MemberProgram.class);
        memberProgram.execute();
    }
}