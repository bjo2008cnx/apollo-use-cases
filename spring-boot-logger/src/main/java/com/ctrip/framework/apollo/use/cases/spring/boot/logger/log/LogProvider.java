package com.ctrip.framework.apollo.use.cases.spring.boot.logger.log;

import com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.common.LogLevelEnum;

import java.util.Map;

/**
 * Log4j抽象类
 *
 * @author
 * @date 2018/8/23
 */
public interface LogProvider<Logger> {
    Map<String, Logger> fetchAllLoggers();

    void refresh(String name, LogLevelEnum logLevel);
}