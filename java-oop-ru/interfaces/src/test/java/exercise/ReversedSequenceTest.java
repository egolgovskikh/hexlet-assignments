package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReversedSequenceTest {

    ReversedSequence reversedSequence;

    @BeforeEach
    void beforeEach() {
        reversedSequence = new ReversedSequence("abcdef");
    }

    @Test
    void testLength() {
        int expectedLength = 6;
        assertEquals(expectedLength, reversedSequence.length());
    }

    @Test
    void testCharAt() {
        char expectedChar = 'e';
        assertEquals(expectedChar, reversedSequence.charAt(1));
    }

    @Test
    void testSubSequence() {
        String expectedSubSequence = "edc";
        assertEquals(expectedSubSequence, reversedSequence.subSequence(1, 4));
    }

    @Test
    void testToString() {
        String expected = "fedcba";
        assertEquals(expected, reversedSequence.toString());
    }
}