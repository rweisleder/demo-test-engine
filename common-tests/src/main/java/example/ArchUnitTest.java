package example;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

import java.time.LocalTime;

@AnalyzeClasses(packages = "example")
class ArchUnitTest {

    @ArchTest
    public static void test(JavaClasses classes) {
        System.out.println(LocalTime.now() + "\tArchUnitTest.test");
    }
}
