package example;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class JUnitTest {

    @Test
    void test() {
        System.out.println(LocalTime.now() + "\tJUnitTest.test");
    }
}
