package com.automation.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {
    private static Logger logger = Logger.getLogger(LogUtil.class);

    static {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j.properties");
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }
}
