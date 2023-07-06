package homework_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileLoggerConfigurationLoader {

	public static FileLoggerConfiguration load(File configFile) {
		String file = null;
		String format = null;
		long maxFileSize = 0;
		LoggingLevelType level = null;
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(configFile)))){
			String line = null;
			int lineIndex = 0;
			
			while((line = reader.readLine()) != null ) {
				
				String[] lineParts = line.split(":");
				
				String value = lineParts[1].trim();
				switch (lineParts[0]) {
				case "FILE":
					file = value;
					break;
				case "FORMAT":
					format = value;
					break;
				case "MAX-SIZE":
					maxFileSize = Long.parseLong(value);
					break;
				case "LEVEL":
					level = LoggingLevelType.valueOf(value);
					break;
				}
//				lines[lineIndex] = line.substring(line.indexOf(" : ") + 1).trim();
//				lineIndex++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file);
		System.out.println(format);
		System.out.println(level);
		System.out.println(maxFileSize);
		if(file == null || format == null || level == null) {
			throw new IllegalArgumentException("Invalid config");
		}
		
		return new FileLoggerConfiguration(
				new File(file),
				format,
				maxFileSize,
				level);
	}
	
}
