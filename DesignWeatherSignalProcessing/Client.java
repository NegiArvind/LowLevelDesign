import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        // Create Sensors
        WeatherSource tempSensor = new TemperatureSensor(Arrays.asList(25.0, 0.0, 27.5, null, 30.0));
        WeatherSource humiditySensor = new HumiditySensor(Arrays.asList(60.0, 62.0, null, 0.0, 65.0));

        // Create processors with filters
        WeatherProcessor processor = new WeatherProcessor();
        processor.addFilter(new IgnoreNullFilter());
        processor.addFilter(new IgnoreZeroFilter());
        processor.addFilter(new MovingAverageFilter(2));

        // process signals
        List<Double> processedTemp = processor.process(tempSensor);
        List<Double> processedHumidity = processor.process(humiditySensor);

        System.out.println("Processed Temperature Signals: " + processedTemp);
        System.out.println("Processed Humidity Signals: " + processedHumidity);
    }
}
