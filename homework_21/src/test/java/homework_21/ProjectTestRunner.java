package homework_21;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;

public class ProjectTestRunner {

	public void runTestByClassName(String className) throws ClassNotFoundException {
	    Class<?> testClass = className.getClass();
	    JUnitCore.runClasses(testClass);
	}

	public void runTestByClass(Class<?> testClass) {
	    JUnitCore.runClasses(testClass);
	}

	public void runTestByClassesName(String[] classNames) throws ClassNotFoundException {
	    List<Class<?>> classes = new ArrayList();
	    for (String className : classNames) {
	        classes.add(className.getClass());
	    }
	    JUnitCore.runClasses(classes.toArray(new Class[0]));
	}

	public void runTestByClasses(Class<?>[] testClasses) {
	    JUnitCore.runClasses(testClasses);
	}

	public void runTestByPackage(String packageName) throws ClassNotFoundException {
	    List<Class<?>> classes = findClassesInPackage(packageName);
	    JUnitCore.runClasses(classes.toArray(new Class[0]));
	}

	private List<Class<?>> findClassesInPackage(String packageName) throws ClassNotFoundException {
	    List<Class<?>> classes = new ArrayList();


	    return classes;
	}


}
