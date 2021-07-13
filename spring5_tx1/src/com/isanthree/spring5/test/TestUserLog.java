package com.isanthree.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUserLog {

    private static final Logger log = LoggerFactory.getLogger(TestUserLog.class);

    public static void main(String[] args) {
        log.info("hello log4j2");
        log.warn("hello log4j2");
    }
}
