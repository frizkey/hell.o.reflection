package id.web.frizky.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public void jump(){
        logger.info(this.getClass().getSimpleName()+ " jump.");
    }
}
