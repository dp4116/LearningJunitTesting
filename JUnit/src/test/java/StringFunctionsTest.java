import org.example.StringFunctions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringFunctionsTest {
    private StringFunctions obj;

    @BeforeEach
    void setup() {
        obj = new StringFunctions();
    }

    @Test
    void testReverse_ByString() {
        String str = "abcde";
        String expected = "edcba";
        assertEquals(obj.reverse(str), expected);
    }

    @Test
    void testReverse_ByOddlengthString() {
        String str = "abcdefg";
        String expectedOutput = "gfedcba";
        assertEquals(obj.reverse(str), expectedOutput);
    }

    @Test
    void testReverse_ByEvenLengthString() {
        String str = "aabbcc";
        String expectedOutput = "ccbbaa";
        assertEquals(obj.reverse(str), expectedOutput);
    }

    @Test
    void testIsPalindrome_ByValidPalindrome() {
        assertTrue(obj.isPalindrome("1abcddcba1"));
        assertTrue(obj.isPalindrome("1ab%#dd#%ba1"));
    }

    @Test
    void testIsPalindrome_ByInValidPalindrome(){
        assertFalse(obj.isPalindrome("aabbccddee%%"));
        assertFalse(obj.isPalindrome("56abbd%%"));
    }

    @Test
    void testConcatenate_ByValidStrings(){
        String expectedOutput = "abcdef";
        assertEquals(obj.concatenate("abc","def"),expectedOutput);
    }

    @Test
    void testConcatenate_ByOneNullString(){
        String str = "abcd";
        assertEquals(obj.concatenate("",str),str,"concatenate is not returning same string-Failed");
    }

    @Test
    void testConcatenate_OfTwoEmptyString(){
        assertEquals(obj.concatenate("",""),"","Concatenate Failed for two null string");
    }

    @Test
    void testCountOccurrence_ByValidInputs(){
        String inputString = "abcdaaghefa";
        assertEquals(obj.countOccurrences(inputString,'a'),4);
    }

    @Test
    void testCountOccurrence_withSpecialChar(){
        String inputString = "abcd%%gh%fa";
        assertEquals(obj.countOccurrences(inputString,'%'),3);
    }

    @Test
    void testCountOccurrence_withOutTarget(){
        String inputString = "abc#$tyoe";
        assertEquals(obj.countOccurrences(inputString,'z'),0);
    }

}
