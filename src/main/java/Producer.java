import org.apache.qpid.jms.JmsConnectionFactory;

import javax.jms.*;

public class Producer {
    public static void main(String[] args) throws JMSException {
        JmsConnectionFactory factory = new JmsConnectionFactory("amqp://localhost:5672");
        Connection con = factory.createConnection("admin", "admin");
        con.start();

        // Creation de la session
        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Mode Queue
        Destination dest = session.createQueue("PARIS");
        MessageProducer producer = session.createProducer(dest);

        //Notre message
        TextMessage msg = session.createTextMessage("Je suis le premier message");

        producer.send(msg);

        con.close();


    }
}
