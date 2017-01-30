import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmokeSensorTest {
  private static final int RANDOM_SEED = 1000;

  @Test
  public void testThatIsTriggeredReturnsFalse() {
    SmokeSensor sensor = new SmokeSensor(RANDOM_SEED);
    boolean isTriggered = sensor.isTriggered();
    assertEquals(false, isTriggered);
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    SmokeSensor sensor = new SmokeSensor(RANDOM_SEED);
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    SmokeSensor sensor = new SmokeSensor(RANDOM_SEED);
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    SmokeSensor sensor = new SmokeSensor(RANDOM_SEED);
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }

}
