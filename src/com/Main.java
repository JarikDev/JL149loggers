package com;

import com.sun.deploy.util.SyncFileAccess;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Main {
    private static final Logger logger = Logger.getGlobal();
    private static final Logger logger2 = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, BackingStoreException {
//        LogManager.getLogManager().readConfiguration();
//        System.out.println(System.getProperty("java.util.logging.config.file"));
//        logger.info("message");
//        -Djava.util.logging.config.file=D:\prog\javalessons\web\JL149loggers\src\com\log.properties
        /*logger.log(Level.FINER, "finer");
        logger.log(Level.INFO, "info");
        logger.log(Level.WARNING, "warning",new Throwable());
        *//*
        Handler handler=new ConsoleHandler();


        new StreamHandler();
        new SocketHandler();*/
        Handler consoleHandler= new FileHandler("%h/myJavaLog.log");
        consoleHandler.setFilter(new MyFilter());
        consoleHandler.setFormatter(new MyFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
        logger.info("info");
        logger.info("info max");




    }
    static class MyFilter implements Filter{
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("max");
        }
    }
    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel()+record.getMessage();
        }
    }
}