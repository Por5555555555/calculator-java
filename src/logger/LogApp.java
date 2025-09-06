package logger;

public class LogApp {
  public enum LogLevelEnum {
    Debug,
    Error,
    Info,
  };

  private LogLevelEnum LogLevel = LogLevelEnum.Debug;

  // Reset
  public static final String RESET = "\033[0m";

  // Text Colors
  public static final String BLACK = "\033[0;30m";
  public static final String RED = "\033[0;31m";
  public static final String GREEN = "\033[0;32m";
  public static final String YELLOW = "\033[0;33m";
  public static final String BLUE = "\033[0;34m";
  public static final String PURPLE = "\033[0;35m";
  public static final String CYAN = "\033[0;36m";
  public static final String WHITE = "\033[0;37m";

  public LogApp setLevel(int LogLevelUser) {
    switch (LogLevelUser) {
      case 2:
        LogLevel = LogLevelEnum.Debug;
      case 3:
        LogLevel = LogLevelEnum.Error;
      default:
        LogLevel = LogLevelEnum.Info;
    }
    return this;
  }

  public <T> void Info(T data) {
    if (LogLevel == LogLevelEnum.Error)
      return;
    System.out.println(BLUE + "[Info] " + RESET + data);
  }

  public <T> void Error(T data) {
    System.out.println(RED + "[Error] " + RESET + data);
  }

  public <T> void Debug(T data) {
    if (LogLevel == LogLevelEnum.Debug) {
      System.out.println(PURPLE + "[Debug] " + RESET + data);
    }
  }

  public <T> void Status(T data) {
    System.out.print(CYAN + "[Status] " + RESET + data);
  }
}
