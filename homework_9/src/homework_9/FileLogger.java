package homework_9;

import java.io.File;

public class FileLogger {
	
	private final FileLoggerConfiguration configuration;
	
	public FileLogger(FileLoggerConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public void info(String message) {
		log(LoggingLevelType.INFO, message);
	}
	
	public void debug(String message) {
		if(configuration.getLevel() != LoggingLevelType.DEBUG) {
			return;
		}
		log(LoggingLevelType.INFO, message);
	}
	
	private void log(LoggingLevelType loggingLevel, String message) {
		
		File logFile = configuration.getFile();
		
	}
}
