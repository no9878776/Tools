package log.slf4j;



import log.ILogParam;
import log.Log;
import log.LogMonitor;
import org.slf4j.Logger;
import org.slf4j.spi.LocationAwareLogger;

import java.text.MessageFormat;


/**
 *
 * @time 2013年11月20日 上午1:22:59
 * @since 1.0.0
 */
public class Slf4jLog implements Log {

    private final LocationAwareLogger log;
    private static final String FQCN = Slf4jLog.class.getName();
    private static LogMonitor logMonitor=null;
    public Slf4jLog(Logger log) {
        this.log = (LocationAwareLogger) log;
    }
    private static LogMonitor getLogMonitor(){
        if(logMonitor==null){
//            if(SpringTool.getApplicationContext()!=null) {
//                logMonitor = SpringTool.getBean(LogMonitor.class);
//            }
        }
        return logMonitor;
    }
    
    public void debug(String message, Object... args) {
        if (isDebugEnabled()) {
            log.log(null, FQCN, LocationAwareLogger.DEBUG_INT, getMsg(message, args), null, null);
        }
    }


    
    public void info(String message, Object... args) {
        log.log(null, FQCN, LocationAwareLogger.INFO_INT, getMsg(message, args), null, null);
    }

    
    public void warn(String message, Object... args) {
        log.log(null, FQCN, LocationAwareLogger.WARN_INT, getMsg(message, args), null, null);
    }

    
    public void error(String message, Object... args) {
        log.log(null, FQCN, LocationAwareLogger.ERROR_INT, getMsg(message, args), null, null);
        if(getLogMonitor()!=null) {
            logMonitor.error(log.getName(), null, MessageFormat.format(message, args));
        }
    }

    
    public void error(Throwable e, String message, Object... args) {
        log.log(null, FQCN, LocationAwareLogger.ERROR_INT, getMsg(message, args), null, e);
        if(getLogMonitor()!=null) {
            logMonitor.error(log.getName(), e, MessageFormat.format(message, args));
        }
    }

    
    public void error(Throwable e) {
        log.log(null, FQCN, LocationAwareLogger.ERROR_INT, getMsg(e.getMessage()), null, e);
        if(getLogMonitor()!=null) {
            logMonitor.error(log.getName(), e, e.getMessage());
        }
    }

    private static String getMsg(String message, Object... args) {

        if (args != null && args.length != 0) {
            return MessageFormat.format(message, args);
        }
        return message;
    }


    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }


    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }


    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }


    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }


    public void debug(String message, ILogParam param) {
        log.debug(getMsg(message), param);
    }


    public void info(String message, ILogParam param) {
        log.info(getMsg(message), param);
    }


    public void warn(String message, ILogParam param) {
        log.warn(getMsg(message), param);
    }


    public void error(String message, ILogParam param) {
        log.error(getMsg(message), param);
    }

}
