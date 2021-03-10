import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
        name = "dojoJmsListener",
        mappedName = "Q.za.co.entelect.dojo.jms",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        },
        messageListenerInterface = MessageListener.class
)
public class QueueListener implements MessageListener {

    public void onMessage(Message message) {
        try {
            System.out.println("::Invoking MDB");
            System.out.println(String.format("Received message with ID %s", message.getJMSMessageID()));
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println(textMessage.getText());
            } else {
                System.out.println("Not a text message. Discarding.");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
