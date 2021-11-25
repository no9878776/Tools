package log.slf4j;


import org.slf4j.LoggerFactory;
import log.Log;
import log.LogCreator;

/**
 * 
 * @since 1.0.0
 *
 * @time 2013年11月20日 上午1:21:59
 */
public class Slf4jLogCreator implements LogCreator {

	public Log createLogger(Class<?> clazz) {
        return new Slf4jLog(LoggerFactory.getLogger(clazz));
    }
	
}
