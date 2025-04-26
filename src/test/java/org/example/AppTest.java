package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AppTest
{

    @BeforeAll
    static void setupClass()
    {
        System.out.println("Class-level setup");
    }

    @BeforeEach
    void setupMethod()
    {
        System.out.println("Method-level setup");
    }

    @Test
    void testAdd() {
        assertEquals(5, App.add(2, 3));
    }

    @Test
    void testSub() {
        assertEquals(1, App.sub(4, 3));
    }

    @Test
    void testMul() {
        assertEquals(12, App.mul(4, 3));
    }

    @Test
    void testDiv() {
        assertEquals(2, App.div(6, 3));
    }

    @Test
    void testDivByZero() {
        assertThrows(ArithmeticException.class, () -> App.div(1, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5"
    })
    void testWithParameter(int a, int b, int expected)      // a=1, b=2, expected=3
    {
        assertEquals(expected, App.add(a, b));
    }

    @Test
    @Timeout(5) // 5 seconds timeout
    void testWithTimeout()
    {
        System.out.println("Test with timeout");
        // Test logic
    }

    @AfterEach
    void cleanupMethod()
    {
        System.out.println("Method-level cleanup");
    }

    @AfterAll static void cleanupClass()
    {
        System.out.println("Class-level cleanup");
    }

}
