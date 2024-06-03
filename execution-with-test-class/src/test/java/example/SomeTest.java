package example;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class SomeTest {

    @Test
    void test() {
        System.out.println(LocalTime.now() + "\tFirstExecutionTest.test");
    }
}
