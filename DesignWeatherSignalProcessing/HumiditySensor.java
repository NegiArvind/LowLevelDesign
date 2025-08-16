import java.util.List;

public class HumiditySensor implements WeatherSource {
    private List<Double> data;

    public HumiditySensor(List<Double> data) {
        this.data = data;
    }

    @Override
    public List<Double> getSignals() {
        return data;
    }
}
