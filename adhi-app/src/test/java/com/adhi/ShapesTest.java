
package com.adhi;

import org.junit.jupiter.api.*;
import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// PER_CLASS: JUnit creates only ONE instance of ShapesTest
// and reuses that same instance for all test methods.
//TestInstance is mainly changes the lifecycle of the test class instance,(where it was called defaultly under every method , now it was called only once, that to in start)
// Default behavior is PER_METHOD, where JUnit creates a new
// ShapesTest instance for every test method.
public class ShapesTest {

    // Instance variable belonging to the ShapesTest object.
    // This variable is shared across test methods when PER_CLASS is used.
    Shapes obj;

    // Constructor executes when JUnit creates the test instance.
    // Because PER_CLASS is used, this constructor executes only once.
    ShapesTest() {
        System.out.println("Test object is created before test methods");
    }

    // @BeforeAll executes only ONCE before all test methods.
    // With PER_CLASS, this method does not need to be static.
    @BeforeAll
    void before() {
        System.out.println("Before all tests");
    }
//
    // @BeforeEach executes BEFORE EVERY test method.
    // Even though the ShapesTest instance is reused,
    // a NEW Shapes object is created and assigned to obj before each test.
    @BeforeEach
    void init() {
        obj = new Shapes();
        System.out.println("ITS JUST A BEGINNING");
    }

    // Checks whether the square area is equal to 16.
    // assertEquals(expected, actual, failureMessage)
    @Test
    void testComputeSquareArea() {
        assertEquals(16.0, obj.CompueSquareArea(4), "wrongi");
    }
//
    // Supplier<String> is used for the failure message.
    // The message is evaluated only if the assertion fails.
    @Test
    void testComputeSquareAreaSupplier() {
        assertEquals(16.0, obj.CompueSquareArea(4), () -> "wrongi");
    }

    // Checks whether the condition evaluates to TRUE.
    @Test
    void test() {
        String str = "Junit";

        assertTrue(str.equals("Junit"));
    }

    // Checks whether the condition evaluates to FALSE.
    @Test
    void test1() {
        String str = "Junit";

        assertFalse(str.length() > 10,
                "vathikuchi pathikathunu sonnathu yaaru");
    }

    // Compares the contents of two arrays.
    @Test
    void testArray() {
        int[] expected = {2, 3, 3, 6};
        int[] actual = {2, 3, 6, 3};

        // Sorts actual in ascending order.
        Arrays.sort(actual);

        // Verifies that both arrays contain the same elements in the same order.
        assertArrayEquals(expected, actual);

        // assertEquals(expected, actual) is not suitable for
        // comparing array contents because arrays are objects.
    }

    // Verifies that the expected NullPointerException is thrown.
    @Test
    void test2() {
        SortingArray array = new SortingArray();

        int[] unsorted = null;

        assertThrows(
                NullPointerException.class,
                () -> array.sortingArray(unsorted)
        );
        // Passes if sortingArray(null) throws NullPointerException.
        // Fails if no exception occurs or a different exception is thrown.
    }

    // Verifies that the purchase operation completes within 2 seconds.
    @Test
    void testPurchase() {
        assertTimeout(Duration.ofSeconds(2), () -> {

            PurchaseCourse pc = new PurchaseCourse();

            boolean status = pc.proceedWithCourse(new JavaCourse());

            System.out.println(status);
        });
        // assertTimeout does not forcibly stop the code when the
        // timeout is exceeded; it reports failure after execution finishes.
    }

    // @AfterEach executes AFTER EVERY test method.
    @AfterEach
    void after() {
        System.out.println("choli mudinchu");
    }

    // @AfterAll executes only ONCE after all test methods finish.
    // With PER_CLASS, this method does not need to be static.
    @AfterAll
    void after1() {
        System.out.println("After all tests");
    }
}
