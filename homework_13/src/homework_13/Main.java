package homework_13;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static final String path1 = "/home/user/my/mainCode.txt";
	public static final String path2 = "/home/user/mainCode.txt";
	
	public static void main(String[] args) {
		File fileOne = new File(path1);
		File fileTwo = new File(path2);
        FileNavigator navigator = new FileNavigator();

        FileData file1 = new FileData(fileOne);
        FileData file2 = new FileData(fileTwo);
        
        navigator.add(path1, file1);
        navigator.add(path2, file2);

        List<FileData> filesAtPath = navigator.find(path1);
        for (FileData file : filesAtPath) {
            System.out.println("Name: " + file.getName() + ",\n Size: " + file.getSize() + 
            		" bytes,\n Path: " + file.getPath());
        }
    }
	
}
	
	class FileData {
		private String name;
		private long size;
		private String path;
		
		FileData(File file) {
			this.name = file.getName();
			this.size = file.length();
			this.path = file.getAbsolutePath();
		}
		
		public String getName() {
			return name;
		}
		
		public long getSize() {
			return size;
		}
		
		public String getPath() {
			return path;
		}
		
	}
	
	
	class FileNavigator<T> {
		private Map<String, List<FileData>> filesMap;

	    public FileNavigator() {
	        filesMap = new HashMap<>();
	    }

	    public void add(String path, FileData file) {
	        if (!isConsistent(path, file)) {
	            System.out.println("Помилка: шлях-ключ і шлях до файлу не співпадають!");
	            return;
	        }

	        if (filesMap.containsKey(path)) {
	            List<FileData> files = filesMap.get(path);
	            files.add(file);
	        } else {
	            List<FileData> files = new ArrayList<>();
	            files.add(file);
	            filesMap.put(path, files);
	        }
	    }

	    public List<FileData> find(String path) {
	        return filesMap.getOrDefault(path, new ArrayList<>());
	    }

	    public List<FileData> filterBySize(String path, long maxSize) {
	        List<FileData> result = new ArrayList<>();
	        if (filesMap.containsKey(path)) {
	            for (FileData file : filesMap.get(path)) {
	                if (file.getSize() <= maxSize) {
	                    result.add(file);
	                    
	                }
	            }
	        }
	        return result;
	    }
		
	    public void remove(String path) {
	        filesMap.remove(path);
	    }

	    public List<FileData> sortBySize(String path) {
	        List<FileData> files = filesMap.getOrDefault(path, new ArrayList<>());
	        files.sort((file1, file2) -> Long.compare(file1.getSize(), file2.getSize()));
	        return files;
	    }

	    public boolean isConsistent(String path, FileData file) {
	        try {
	        	return file.getPath().equals(path);	   
	        } catch (NullPointerException e) {
	        	return false;
	        }
	    }
	}
