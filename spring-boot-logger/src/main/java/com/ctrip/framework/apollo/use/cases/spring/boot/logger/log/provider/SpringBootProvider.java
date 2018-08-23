package com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.provider;

import com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.LogProvider;
import com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.common.LogLevelEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * SpringBootLog实现
 *
 * @author
 * @date 2018/8/23
 */
@Service
public class SpringBootProvider implements LogProvider {

    @Autowired
    private LoggingSystem loggingSystem;

    @Override
    public Map fetchAllLoggers() {
        return null;
    }

    @Override
    public void refresh(String name, LogLevelEnum logLevel) {
        LogLevel level = LogLevel.valueOf(logLevel.name());
        loggingSystem.setLogLevel(name, level);
    }
}