import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
        name = "dojoJmsListener",
        activationConfig = {@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                            @ActivationConfigProperty(propertyName = "destination", propertyValue = "Q.za.co.entelect.dojo.jms")}
)
public class QueueListener implements MessageListener {

    public void onMessage(Message message) {
        try {
            System.out.println("::Invoking MDB");
            System.out.println(String.format("Received message with ID %s", message.getJMSMessageID()));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
