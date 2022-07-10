package classes;
import org.jboss.logging.Logger;
public class MessagesWithJboss {
    private Logger logger = Logger.getLogger(MessagesWithJboss.class);
    public void printMessage(String text){
        logger.info(text);
    }
}
