package wonderland.number;
import static wonderland.number.Utils.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilsTest {
    @Test
    public void test_isSameDigits_when_m_has_less_digits_than_n_expect_false(){
        assertFalse(hasSameDigits(1,10));
        assertFalse(hasSameDigits(22,333));
        assertFalse(hasSameDigits(555,456976));
    }

    @Test
    public void test_isSameDigits_when_m_has_different_digits_to_n_expect_false(){
        assertFalse(hasSameDigits(123,456));
        assertFalse(hasSameDigits(112,122));
        assertFalse(hasSameDigits(311,331));
        assertFalse(hasSameDigits(1234,1456));
        assertFalse(hasSameDigits(999111,999000));
    }

    @Test
    public void test_isSameDigits_when_m_has_the_same_digits_to_n_expect_true(){
        assertTrue(hasSameDigits(123,321));
        assertTrue(hasSameDigits(221,122));
        assertTrue(hasSameDigits(221,122));
        assertTrue(hasSameDigits(1111,1111));
        assertTrue(hasSameDigits(456976,649765));
    }

}
