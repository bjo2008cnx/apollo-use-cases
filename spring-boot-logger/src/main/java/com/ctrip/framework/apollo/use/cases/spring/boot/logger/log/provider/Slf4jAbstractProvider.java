package com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.provider;

import com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.type.LogConstant;
import com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.type.LogType;
import org.slf4j.impl.StaticLoggerBinder;

import static com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.type.LogConstant.LOG4J2_LOGGER_FACTORY;
import static com.ctrip.framework.apollo.use.cases.spring.boot.logger.log.type.LogConstant.LOGBACK_LOGGER_FACTORY;

/**
 * Slf4j工具类
 *
 * @author
 * @date 2018/8/23
 */
public class Slf4jAbstractProvider {
    /**
     * 检测slf4j 绑定的Log类型
     *
     * @return
     */
    public static LogType check() {
        String type = StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr();
        if (LogConstant.LOG4J_LOGGER_FACTORY.equals(type)) {
            return LogType.LOG4J;
        } else if (LOGBACK_LOGGER_FACTORY.equals(type)) {
            return LogType.LOGBACK;
        } else if (LOG4J2_LOGGER_FACTORY.equals(type)) {
            return LogType.LOG4J2;
        } else {
            return LogType.UNKNOWN;
        }
    }
}