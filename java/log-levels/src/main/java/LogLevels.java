public class LogLevels {
    
    public static String message(String logLine) {
        String message =  logLine.split(":")[1].trim();
        return message;
    }

    public static String logLevel(String logLine) {
        String message = logLine.split("]")[0].substring(1).toLowerCase();
        return message;
    }

    public static String reformat(String logLine) {
        String message =  logLine.split(":")[1].trim();
        String logLineMessage = logLine.split("]")[0].substring(1).toLowerCase();
        String formatMessage = String.format("%s (%s)", message, logLineMessage);

        return formatMessage.toString();
    }
}
