package cc.anjun.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppProducer {
    private static final String url = "tcp://localhost:61616";
    private static final String queueName= "topic-test";
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
       Destination destination = session.createTopic(queueName);
       MessageProducer producer = session.createProducer(destination);
       for (int i=0;i<100;i++){
           TextMessage msg = session.createTextMessage("test:+"+i);
           producer.send(msg);
           System.out.println("发送msg:"+msg.getText());
       }
       connection.close();
    }
}
