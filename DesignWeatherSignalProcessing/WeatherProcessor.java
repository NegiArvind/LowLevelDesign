import java.util.ArrayList;
import java.util.List;

public class WeatherProcessor {
    private List<SignalFilter> signalFilters = new ArrayList<>();

    public void addFilter(SignalFilter filter) {
        signalFilters.add(filter);
    }

    public List<Double> process(WeatherSource source) {
        List<Double> signals = source.getSignals();
        for(SignalFilter filter: signalFilters) {
            signals = filter.apply(signals);
        }
        return signals;
    }
}
