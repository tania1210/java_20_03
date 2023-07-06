package homework_9;

import java.io.File;

public class FileMaxSizeReachedException extends RuntimeException{
	
	public FileMaxSizeReachedException(File logFile) {
		super("Log file " + logFile + " max size reached");
	}
}
