import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        // This is chain of logging processor. First request will go to info, if it can't serve then request go to debug
        // if it also can't server then request will go to error
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.ERROR, "This is error message");
        logProcessor.log(LogProcessor.INFO, "This is info message");
        logProcessor.log(LogProcessor.DEBUG, "This is debug message");
    }
}
