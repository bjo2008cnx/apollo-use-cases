package com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.type;


import com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.common.ClassUtil;
import com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.provider.Slf4jAbstractProvider;

/**
 * Log类型检测
 *
 * @author
 * @date 2018/8/23
 */
public class LogTypeChecker {

    public static LogTypeEnum check() {
        if (ClassUtil.isPresent("org.slf4j.impl.StaticLoggerBinder")) {
            return Slf4jAbstractProvider.check();
        }
        if (ClassUtil.isPresent("org.apache.log4j.Logger")) {
            return LogTypeEnum.LOG4J;
        }
        if (ClassUtil.isPresent("org.apache.logging.log4j.core.config.LoggerConfig")) {
            return LogTypeEnum.LOG4J2;
        }
        if (ClassUtil.isPresent("ch.qos.logback.classic.Logger")) {
            return LogTypeEnum.LOGBACK;
        }
        return LogTypeEnum.UNKNOWN;
    }
}