package pl.zebek.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by Bogumil Zebek on 6/26/18.
 */
@DisplayName("A special test case")
class FirstJUnit5Test {

	@Test
	@DisplayName("more descriptive test name")
	void myFirstTest() {
		assertEquals(2, 1 + 1);
	}

	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
		assertTrue(isPalindrome(candidate));
	}

	private boolean isPalindrome(String candidate) {
		// TODO Auto-generated method stub
		return true;
	}

	@TestFactory
	Collection<DynamicTest> dynamicTestsFromCollection() {
		return Arrays.asList(dynamicTest("1st dynamic test", () -> assertTrue(true)),
				dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2))
				);
	}
	
	
	@RepeatedTest(value = 2)
	public void shouldBeRepited() {
		System.out.println("# Repeat");
	}

	

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }
    
    @Nested
    @DisplayName("when new")
    class WhenNew {

        private Stack stack;

		@BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }
    }
    
    
    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertNotEquals(9, argument);
    }

    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }
}
