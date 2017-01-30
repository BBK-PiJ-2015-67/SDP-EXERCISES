
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class NumberPersonalitiesTest {

  @Test
  public void testThatIsPrimeReturnsTrueForPrimeNumber () {
    assertTrue(NumberPersonalities.isPrime(2));
  }

  @Test
  public void testThatIsPrimeReturnsFalseForNonPrimeNumber () {
    assertFalse(NumberPersonalities.isPrime(4));
  }

  @Test
  public void testThatIsPrimeReturnsFalseForNegativeNumber () {
    assertFalse(NumberPersonalities.isPrime(-3));
  }

}
