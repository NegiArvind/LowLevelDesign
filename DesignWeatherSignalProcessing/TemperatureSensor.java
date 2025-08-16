import java.util.List;

public class TemperatureSensor implements WeatherSource {
   private final List<Double> data;

   public TemperatureSensor(List<Double> data) {
       this.data = data;
   }

    @Override
    public List<Double> getSignals() {
        return data;
    }
}
