package cc.anjun.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppCunsumer {
    private static final String url = "tcp://localhost:61616";
    private static final String queueName= "activemq-test";
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage msg = (TextMessage)message;
                try {
                    System.out.println("接收到:"+msg.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

//        connection.close();
    }
}
