package homework_9;

import java.io.File;

public class FileLoggerConfiguration {

	private File file;
	private String format;
	private long maxFileSize;
	private LoggingLevelType level;
	
	public FileLoggerConfiguration(File file, String format, long maxFileSize, LoggingLevelType level) {
		this.setFile(file);
		this.setFormat(format);
		this.setLevel(level);
		this.setMaxFileSize(maxFileSize);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public long getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(long maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	public LoggingLevelType getLevel() {
		return level;
	}

	public void setLevel(LoggingLevelType level) {
		this.level = level;
	}
	

}
