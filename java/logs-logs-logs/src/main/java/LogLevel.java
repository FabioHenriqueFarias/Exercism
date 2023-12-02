public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    UNKNOWN(0),
    FATAL(42);

    private final int index;

    LogLevel(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
