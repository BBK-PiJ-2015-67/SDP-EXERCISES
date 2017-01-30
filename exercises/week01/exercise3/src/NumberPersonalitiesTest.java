import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NumberPersonalitiesTest {

  @Test
  public void testThatIsPrimeReturnsTrueForPrimeNumber () {
    assertTrue(NumberPersonalities.isPrime(2));
  }

}
