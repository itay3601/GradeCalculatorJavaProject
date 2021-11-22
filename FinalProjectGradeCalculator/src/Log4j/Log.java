package Log4j;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

/**
 * this class is define log message,this class create log.txt file and add and write the message log in it.
 */

public class Log {
    private static Logger logger;

    /**
     * Constructor get logger from org.apache.log4j.Logger and put nameclass
     * @param nameClass name of the claas how crate this object
     */
    public Log(String nameClass) {
        logger=Logger.getLogger(nameClass);


    }

    /**
     * add and write msg on logs.txt
     * @param msg msg to add
     */

    public void addLogerInfo(String msg){
        BasicConfigurator.configure();

        try{
            logger.addAppender(new FileAppender(new SimpleLayout(),"logs.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info(msg);
        BasicConfigurator.resetConfiguration();

    }

    /**
     * add and write error msg on logs.txt
     * @param msg msg to add
     */
    public void addLogerEror(String msg){
        BasicConfigurator.configure();

        try{
            logger.addAppender(new FileAppender(new SimpleLayout(),"logs.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.error(msg);
        BasicConfigurator.resetConfiguration();

    }
}