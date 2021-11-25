package log;

public interface LogMonitor {
    void error(String logName, Throwable throwable, String message);
}
