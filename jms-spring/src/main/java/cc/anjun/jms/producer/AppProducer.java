package cc.anjun.jms.producer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService producerService=   context.getBean(ProducerService.class);
        for(int i=0;i<111;i++){
            producerService.sendMessage("msg:"+i);
        }
        context.close();
    }
}
