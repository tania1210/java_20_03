package homework_19;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class TestRunner {

	public static void start(Class<?> testClass) throws Exception {
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        List<Method> testMethods = new ArrayList();

        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
            	beforeSuiteMethod = method;
            }else if (method.isAnnotationPresent(AfterSuite.class)) {
            	afterSuiteMethod = method;
            }else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }

        beforeSuiteMethod.invoke(null);

        testMethods.sort((m1, m2) ->  m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority());
        for (Method testMethod : testMethods) {
            testMethod.invoke(null);
        }

        afterSuiteMethod.invoke(null);
    }
}
