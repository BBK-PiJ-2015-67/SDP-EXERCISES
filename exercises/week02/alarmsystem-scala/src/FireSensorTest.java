import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FireSensorTest {
  private static final int RANDOM_SEED = 1000;
  private static final int CHANCE_TO_TRIGGER = 5;
  private static final int BATTERY_DRAIN = 10;
  private static final String SENSOR_TYPE = "Fire sensor";
  private static final String SENSOR_LOCATION = "Lobby";

  @Test
  public void itShouldTriggerXPercentOfTheTime() {
    FireSensor sensor = new FireSensor(RANDOM_SEED);
    List<Integer> results = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      results.add(sensor.isTriggered() ? 1 : 0);
    }

    int triggerCount = (int)results.stream()
      .filter(i -> (i == 1))
      .count();

    assertEquals(CHANCE_TO_TRIGGER, triggerCount);
  }

  @Test
  public void testThatIsTriggeredReturnsFalse() {
    FireSensor sensor = new FireSensor(RANDOM_SEED);
    boolean isTriggered = sensor.isTriggered();
    assertEquals(false, isTriggered);
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    FireSensor sensor = new FireSensor(RANDOM_SEED);
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    FireSensor sensor = new FireSensor(RANDOM_SEED);
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    FireSensor sensor = new FireSensor(RANDOM_SEED);
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }
}
