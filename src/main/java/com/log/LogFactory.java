package log;

import log.slf4j.Slf4jLogCreator;

/**
 *
 *
 * @since 1.0.0
 *
 * @time 2013年11月20日 上午1:18:38
 */
public class LogFactory {

    private static LogCreator logCreator;
    private static final Log LOG = getLog(LogFactory.class);

    private LogFactory() {
    }

    /**
     *
     *
     * @param logCreator
     * @since 1.0.0
     *
     * @time 2013年11月20日 上午1:20:44
     */
    public static void setLogCreator(LogCreator logCreator) {
        LogFactory.logCreator = logCreator;
    }

    /**
     *
     *
     * @param clazz
     * @return
     * @since 1.0.0
     *
     * @time 2013年11月20日 上午1:20:47
     */
    public static Log getLog(Class<?> clazz) {
        if (logCreator == null) {
            logCreator = new Slf4jLogCreator();
        }
        return logCreator.createLogger(clazz);
    }

    /**
     * 获取默认的日志记录器
     *
     * @return 默认的日志记录器
     */
//    public static Log getLog() {
//        return LOG;
//    }

}