package homework_21;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectTestRunnerTest {

    @Test
    public void testRunTestByClassName() throws ClassNotFoundException {
        ProjectTestRunner testRunner = new ProjectTestRunner();
        testRunner.runTestByClassName("TestRunner");
        // Додайте перевірку, що тести відпрацювали успішно
    }

    @Test
    public void testRunTestByClass() {
        ProjectTestRunner testRunner = new ProjectTestRunner();
        testRunner.runTestByClass(TestRunner.class);
        // Додайте перевірку, що тести відпрацювали успішно
    }

    @Test
    public void testRunTestByClassesName() throws ClassNotFoundException {
        ProjectTestRunner testRunner = new ProjectTestRunner();
        String[] classNames = { "TestRunner", "TestRunner" };
        testRunner.runTestByClassesName(classNames);
        // Додайте перевірку, що тести відпрацювали успішно
    }

    @Test
    public void testRunTestByClasses() {
        ProjectTestRunner testRunner = new ProjectTestRunner();
        Class<?>[] testClasses = { TestRunner.class, TestRunner.class };
        testRunner.runTestByClasses(testClasses);
        // Додайте перевірку, що тести відпрацювали успішно
    }

    @Test
    public void testRunTestByPackage() throws ClassNotFoundException {
        ProjectTestRunner testRunner = new ProjectTestRunner();
        testRunner.runTestByPackage("TestRunner");
        // Додайте перевірку, що тести відпрацювали успішно
    }
}


