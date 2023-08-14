package homework_19;

import annotations.BeforeSuite;
import annotations.Test;
import annotations.AfterSuite;

public class TestClass {

	@BeforeSuite
    public static void beforeSuite() {
        System.out.println("BeforeSuite method");
    }
	
	@Test(priority = 2)
    public static void test1() {
        System.out.println("Test method 1");
    }
	
	@Test(priority = 1)
    public static void test2() {
        System.out.println("Test method 2");
    }
	
	@Test(priority = 3)
    public static void test3() {
        System.out.println("Test method 3");
    }
	
	@AfterSuite
    public static void afterSuite() {
        System.out.println("AfterSuite method");
    }
	
}
