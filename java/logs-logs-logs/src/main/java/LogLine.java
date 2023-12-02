import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLine {

    String logLine;
    LogLevel logLevel;

    public LogLine(String logLine) {
        this.logLine = logLine;
        this.getLogLevel();
    }

    public LogLevel getLogLevel() {

        this.logLevel = LogLevel.UNKNOWN;

        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(this.logLine);

        if(!matcher.find()){
            return this.logLevel;
        }

        switch (matcher.group(1)) {
            case "TRC":  this.logLevel = LogLevel.TRACE;
                         break;
            case "DBG":  this.logLevel = LogLevel.DEBUG;
                         break;
            case "INF":  this.logLevel = LogLevel.INFO;
                         break;
            case "WRN":  this.logLevel = LogLevel.WARNING;
                         break;
            case "ERR":  this.logLevel = LogLevel.ERROR;
                         break;
            case "FTL":  this.logLevel = LogLevel.FATAL;
                         break;
            default: this.logLevel = LogLevel.UNKNOWN;
        };

        return this.logLevel;
    }

    public String getOutputForShortLog() {

        String message = this.logLine.substring(this.logLine.indexOf(":") + 2);
        return String.format("%d:%s", this.logLevel.getIndex(), message);
    }
}
