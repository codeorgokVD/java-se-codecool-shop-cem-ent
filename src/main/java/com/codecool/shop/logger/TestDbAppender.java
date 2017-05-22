package com.codecool.shop.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;

public class TestDbAppender {

    private static final Logger logger = LoggerFactory.getLogger(TestDbAppender.class);

    public TestDbAppender() {
        logger.info("Class instance created at {}",
                DateFormat.getInstance().format(new Date()));
    }

    public void doTask() {
        logger.info("info - in do task");
        logger.trace("In doTask");
        logger.trace("doTask complete");
    }

    public static void main(String[] args) {
        logger.warn("Running code...");
        TestDbAppender dbAppender = new TestDbAppender();
        dbAppender.doTask();
        logger.debug("Code execution complete.");
    }

}