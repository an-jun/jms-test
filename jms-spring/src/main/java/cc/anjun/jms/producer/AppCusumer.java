package cc.anjun.jms.producer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class AppCusumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
